import java.io.IOException;
import java.util.*;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FullIndexMR {
    public static class MapClass extends Mapper<LongWritable, Text, Text, Text> {
        private Text word = new Text();
        private Text docInfo = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString().toLowerCase();
            String[] words = line.split("\\s+");

            FileSplit fileSplit = (FileSplit) context.getInputSplit();
            String fileName = fileSplit.getPath().getName();
            int docId = Integer.parseInt(fileName.substring(4, fileName.length() - 4));

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                this.word.set(word);
                this.docInfo.set("{" + docId + "," + i + "}"); // Store the document ID and position of the word
                context.write(this.word, this.docInfo);
            }
        }
    }

    public static class ReduceClass extends Reducer<Text, Text, Text, Text> {
        private Text result = new Text();

        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            StringBuilder sb = new StringBuilder();
            List<String> docInfoList = new ArrayList<>();

            for (Text value : values) {
                docInfoList.add(value.toString());
            }

            Collections.sort(docInfoList);

            sb.append("[");
            for (int i = 0; i < docInfoList.size(); i++) {
                sb.append(docInfoList.get(i));
                if (i < docInfoList.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");

            result.set(sb.toString());
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "FullIndexMR");
        job.setJarByClass(FullIndexMR.class);
        job.setMapperClass(MapClass.class);
        job.setReducerClass(ReduceClass.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        TextOutputFormat.setOutputPath(job, new Path(args[1]));
        job.waitForCompletion(true);
    }
}

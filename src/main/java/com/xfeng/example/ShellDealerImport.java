package com.xfeng.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuefeng.wang
 * @date 2020-10-30
 */
public class ShellDealerImport {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\TY\\Desktop\\cfDealer.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            list.add(str);
        }
        String sql = "insert into dealer (dealer_type, parent_id, name, code, level, ese_id, dept_id, status, created_by, created_time,\n" +
                "                    updated_by, updated_time, version, custom_fields, sales_area_code, province_code, city_code,\n" +
                "                    county_code, address)\n" +
                "select 1, null, '%s', '%s', 2, 3, 3, 1, 7, NOW(), 7, NOW(), 1, null, null, null, null, null, null\n" +
                "from DUAL\n" +
                "where not exists (select * from dealer where code = '%s' and ese_id = 3);";
        fileReader.close();
        bufferedReader.close();
        int level1 = 0;
        List<String> dealers = new ArrayList<>();
        for (String s : list) {
            String[] dealer = s.split(",");
            if (dealer[0].equals(dealer[1])) {
                level1++;
                String deaSql = String.format(sql, dealer[2], dealer[1]);
                dealers.add(dealer[1]);
            }
        }
        writeFile(dealers);
        System.out.println(level1);
    }

    public static void writeFile(List<String> data) {
        try {
            File writeName = new File("C:\\Users\\TY\\Desktop\\cfDealerOneCode.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for (String item : data) {
                    out.write(item + ",\r\n"); // \r\n即为换行
                }

                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

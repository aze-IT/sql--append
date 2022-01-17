import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * sql语句转为StringBuffer的append语句
 */
class StringToStringBuffer {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入：(输入stop来结束)");
        String line;
        StringBuilder s = new StringBuilder();
        s.append("StringBuilder sql = new StringBuilder();\n");
        StringToStringBuffer stosb = new StringToStringBuffer();
        while ((line = bf.readLine()) != null) {
            if (line.equals("stop")) {
                break;
            } else {
                s.append("sql.append(\" ");
                s.append(stosb.sToS(line));
                s.append("\");\n");
            }
        }
        System.out.println(s.toString());
    }

    private String sToS(String s) {
        {
            //去除回车：
            s = s.replace("\n", ")sql.append(");
            s = s.replace("\r", ")sql.append(");
            //去水平制表符
            s = s.replace("\t", "");
            for (int i = 0; i < 5; i++) {
                //去多个空格：
                s = s.replace("\\s\\s", "");
            }
            return s;
        }
    }
}
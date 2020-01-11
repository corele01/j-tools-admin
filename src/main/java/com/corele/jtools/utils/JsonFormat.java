package com.corele.jtools.utils;


import java.util.Stack;

/**
 * @author liujun
 */
public class JsonFormat {

    private String jsonStr;
    private String formatStr;

    private int offset = 1;
    private StringBuffer formatBuffer;
    private String tab = "";
    private char nowAfter;

    private JsonFormat(){}

    public JsonFormat(String json){
        this.jsonStr = json;
    }

    public String getBaseString(){
        return jsonStr;
    }

    public String format(){
        clean();
        checkString();

        Stack<Character> jsonStack = new Stack<>();
        formatBuffer = new StringBuffer();
        for (char c : formatStr.toCharArray()){
            switch (c){
                case '[':
                    jsonStack.push(c);
                    tabAdd();
                    addElement(c);
                    addLn();
                    break;
                case ']':
                    Character pop1 = jsonStack.pop();
                    if (pop1 != '['){
                        throw new IllegalArgumentException("The string not is json");
                    }
                    addLn();
                    tabSub();
                    addTab();
                    addElement(c);
                    break;
                case '{':
                    Character peek1 = jsonStack.peek();
                    if (peek1 == ','){
                        jsonStack.pop();
                    }
                    jsonStack.push(c);
                    addTab();
                    addElement(c);
                    addLn();
                    tabAdd();
                    break;
                case '}':
                    Character pop = jsonStack.pop();
                    if (pop == '!'){
                        pop = jsonStack.pop();
                    }
                    if (pop == '{'){
                        tabSub();
                        addLn();
                        addTab();
                        addElement(c);
                    }else {
                        throw new IllegalArgumentException("The string not is json");
                    }
                    break;
                case '"':
                    Character peek = jsonStack.peek();
                    if (peek == '{' || peek == ','){
                        if (peek == ','){
                            jsonStack.pop();
                        }
                        jsonStack.push(c);
                        if (nowAfter != ':'){
                            addTab();
                        }
                        addElement(c);
                        break;
                    }
                    if (peek == '"'){
                        jsonStack.pop();
                        addElement(c);
                        jsonStack.push('!');
                        break;
                    }
                    throw new IllegalArgumentException("The string not is json");
                case ',':
                    Character peek2 = jsonStack.peek();
                    if (peek2 == '!'){
                        jsonStack.pop();
                    }
                    jsonStack.push(c);
                    addElement(c);
                    addLn();
                    break;
                case ':':
                    if (nowAfter != '"'){
                        throw new IllegalArgumentException("The string not is json");
                    }
                    Character peek3 = jsonStack.peek();
                    if (peek3 == '!'){
                        jsonStack.pop();
                    }
                    addElement(c);
                    break;
                default:
                    addElement(c);
                    break;
            }
        }
        if (!jsonStack.isEmpty()){
            System.out.println(jsonStack.toArray());
            throw new IllegalArgumentException("The string not is json");
        }
        return formatBuffer.toString();
    }

    private void tabSub() {
        tab = tab.substring(0,tab.length()-4);
    }

    private void tabAdd() {
        tab += "    ";
    }

    private void addTab() {
        formatBuffer.append(tab);
    }

    private void addLn() {
        formatBuffer.append("\n");
    }

    private void checkString() {
        String firstChar = formatStr.substring(0, 2);
        String lastChar = formatStr.substring(formatStr.length()-1);
        if (isCheck(firstChar, lastChar)){
            return;
        }else {
            throw new IllegalArgumentException("The string not is json");
        }
    }

    private boolean isCheck(String firstChar, String lastChar) {
        return (firstChar.equalsIgnoreCase("{\"") && lastChar.equalsIgnoreCase("}"))
                || (firstChar.substring(0,1).equalsIgnoreCase("[") && lastChar.equalsIgnoreCase("]"));
    }

    private void clean() {
        formatStr = jsonStr.replaceAll("\\n", "");
        formatStr = formatStr.replaceAll("\\t","");
        formatStr = formatStr.replaceAll("\\s","");
    }

    private void addElement(char c) {
        formatBuffer.append(c);
        nowAfter = c;
        offset ++;
    }


    public static void main(String[] args) {
        JsonFormat json = new JsonFormat("[{\"a\":b,\"c\":\"d\"},{\"a\":b,\"c\":\"d\"}]");
        System.out.println(json.getBaseString());
        System.out.println(json.format());
    }
}

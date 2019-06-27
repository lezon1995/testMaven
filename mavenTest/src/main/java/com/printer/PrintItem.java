package com.printer;


/**
 * 打印条目 1个标题 多个内容
 *
 * @author zhuliang
 * @date 2019/5/7
 */
public class PrintItem implements Comparable<PrintItem> {
    private String label;
    private String[] datas;
    private int weight;

    public PrintItem() {
    }


    public PrintItem(String label, String[] datas, int weight) {
        this.label = label;
        this.datas = datas;
        this.weight = weight;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String[] getDatas() {
        return datas;
    }

    public void setDatas(String[] datas) {
        this.datas = datas;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(PrintItem item) {
        return item.weight - this.weight;
    }
}

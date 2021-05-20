package com.xue.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Page {
    /*开始位置*/
    private int start = 0;
    /*每页显示条数*/
    private int count;
    /*总条数*/
    private int total;
    /*参数*/
    private String param;
    /*默认每页显示条数*/
    private static final int defaultCount = 5;

    /*判断是否有上一页*/
    public boolean isHasPrevious(){
        //开始位置为0
        if (start == 0)
            return false;
        else
            return true;
    }

    /*判断是否有下一页*/
    public boolean isHasNext(){
        //开始位置为最后一页开始
        if (start == getLast())
            return false;
        else
            return true;
    }

    /*获取最后一页开始*/
    public int getLast() {
        int last;
        // total：50，count：5，last：45
        if (total % count == 0)
            last = total - count;
            // total：52，count：5，last：50
        else
            last = total - total % count;
        // 不为负
        last = last < 0 ? 0 : last;
        return last;
    }

    /*获取总页数*/
    public int getTotalPage() {
        int totalPage;
        // total：50，count：5，totalPage：10
        if (total % count == 0)
            totalPage = total / count;
            // total：52，count：5，totalPage：11
        else
            totalPage = total / count + 1;
        // 最小值为1
        if (totalPage == 0)
            totalPage = 1;
        return totalPage;
    }

    public Page() {
        count = defaultCount;
    }

    public Page(int start, int count){
        this();
        this.start = start;
        this.count = count;
    }
}

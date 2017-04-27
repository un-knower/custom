package com.alipay.simplehbase.antlr.manual.visitor;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_endContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_onerowkeyContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_startAndEndContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_startContext;
import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.antlr.manual.RowKeyRange;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * RowKeyRange visitor.
 * 
 * @author xinzhi
 * */
public class RowKeyRangeVisitor extends StatementsBaseVisitor<RowKeyRange> {
    private SimpleHbaseRuntimeSetting simpleHbaseRuntimeSetting;

    public RowKeyRangeVisitor(
            SimpleHbaseRuntimeSetting simpleHbaseRuntimeSetting) {
        this.simpleHbaseRuntimeSetting = simpleHbaseRuntimeSetting;
    }

    @Override
    public RowKeyRange visitRowkeyrange_start(
            Rowkeyrange_startContext startContext) {
        RowKeyRange range = new RowKeyRange();
        range.setStart(ContextUtil.parseRowKey(startContext.rowkeyexp(),
                simpleHbaseRuntimeSetting));
        range.setEnd(RowKeyUtil.END_ROW);
        return range;
    }

    @Override
    public RowKeyRange visitRowkeyrange_end(Rowkeyrange_endContext endContext) {
        RowKeyRange range = new RowKeyRange();
        range.setStart(RowKeyUtil.START_ROW);
        range.setEnd(ContextUtil.parseRowKey(endContext.rowkeyexp(),
                simpleHbaseRuntimeSetting));
        return range;
    }

    @Override
    public RowKeyRange visitRowkeyrange_startAndEnd(
            Rowkeyrange_startAndEndContext startAndEndContext) {
        RowKeyRange range = new RowKeyRange();
        range.setStart(ContextUtil.parseRowKey(startAndEndContext.rowkeyexp(0),
                simpleHbaseRuntimeSetting));
        range.setEnd(ContextUtil.parseRowKey(startAndEndContext.rowkeyexp(1),
                simpleHbaseRuntimeSetting));
        return range;
    }

    @Override
    public RowKeyRange visitRowkeyrange_onerowkey(
            Rowkeyrange_onerowkeyContext ctx) {
        RowKeyRange range = new RowKeyRange();
        RowKey rowKey = ContextUtil.parseRowKey(ctx.rowkeyexp(),
                simpleHbaseRuntimeSetting);
        range.setStart(rowKey);
        range.setEnd(rowKey);
        return range;
    }
}

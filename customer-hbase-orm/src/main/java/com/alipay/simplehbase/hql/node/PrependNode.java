package com.alipay.simplehbase.hql.node;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;
/**
 * @author xinzhi
 */
abstract public class PrependNode extends HQLNode {

    private String prependValue;

    protected PrependNode(HQLNodeType hqlNodeType) {
        super(hqlNodeType);
    }

    public String getPrependValue() {
        return prependValue;
    }

    public void setPrependValue(String prependValue) {
        this.prependValue = prependValue;
    }
}

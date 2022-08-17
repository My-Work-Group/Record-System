package com.ruoyi.project.record.offsite.enumerate;

public enum WeightLimit {
    vehAxleNum_2(2, 18),
    vehAxleNum_3(3, 27),
    vehAxleNum_4(4, 37),
    vehAxleNum_5(5, 43),
    vehAxleNum_6(6, 49);

    private int vehAxleNum;
    private int weightLimit;

    WeightLimit(int vehAxleNum, int weightLimit) {
        this.vehAxleNum = vehAxleNum;
        this.weightLimit = weightLimit;
    }
    // 普通方法
    public static int getWeightLimit(int vehAxleNum) {
        for (WeightLimit w : WeightLimit.values()) {
            if (w.getVehAxleNum() == vehAxleNum) {
                return w.weightLimit;
            }
        }
        return -1;
    }

    public int getVehAxleNum() {
        return vehAxleNum;
    }

    public void setVehAxleNum(int vehAxleNum) {
        this.vehAxleNum = vehAxleNum;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }
}

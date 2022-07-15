package com.ruoyi.framework.enumerate;


/**
 * 江阴 17个非现在治超点位
 */
public enum CheckSite {
    SITE_1(1, "G346 K152+500高新区澄张公路东向西"),
    SITE_2(2, "G346 K194+400璜土滨江西路西向东"),
    SITE_3(3, "S122 K115+475璜土港城大道西向东"),
    SITE_4(4, "S122 K156+50云亭江阴大道西向东"),
    SITE_5(5, "S122 K159+500云亭江阴大道东向西"),
    SITE_6(6, "S122 K178+460华士芙蓉大道东向西"),
    SITE_7(7, "S229 K181+450申港海港大道北向南"),
    SITE_8(8, "S229 K181+520申港海港大道南向北"),
    SITE_9(9, "S232 K310+335利港省庄大道南向北"),
    SITE_10(10, "S259 K15+475华士红旗路北向南"),
    SITE_11(11, "S261 K3+635申港亚包大道南向北"),
    SITE_12(12, "S340 K10+564顾山云顾路东向西"),
    SITE_13(13, "S357 K10+005顾山暨南大道东向西"),
    SITE_14(14, "S442 K5+785顾山锡张路北向南"),
    SITE_15(15, "X257 K1+480璜土扬子大道南向北"),
    SITE_16(16, "X258 K1+850周庄砂山大道北向南"),
    SITE_17(17, "X302 K23+320璜土镇澄路西向东"),
    ;
    private int siteId;
    private String siteName;

    CheckSite(int siteId, String siteName) {
        this.siteId = siteId;
        this.siteName = siteName;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}

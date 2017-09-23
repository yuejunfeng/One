package com.example.admin.one.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/22.
 */

public class ZuiXinBean {


    /**
     * date : 20170922
     * stories : [{"images":["https://pic4.zhimg.com/v2-d49927983b0664ecc37641ff05fc5fc3.jpg"],"type":0,"id":9624093,"ga_prefix":"092220","title":"承认吧，所谓读书，就是纪录一本书的拥有过程给别人看"},{"images":["https://pic1.zhimg.com/v2-c12f6df06951314d04bba845942c331c.jpg"],"type":0,"id":9627209,"ga_prefix":"092219","title":"马化腾表情包的背后"},{"images":["https://pic1.zhimg.com/v2-aa39c4cd397873dbbdf259e67e5f4334.jpg"],"type":0,"id":9624559,"ga_prefix":"092218","title":"隔两分钟就忍不住拿起手机\u2026\u2026怎么才能静下心来做事？"},{"images":["https://pic3.zhimg.com/v2-740acaaa25485d14a5d5b2a1e40aef26.jpg"],"type":0,"id":9627506,"ga_prefix":"092217","title":"辉煌中国 · 贵州和大数据，天才设想的火花"},{"images":["https://pic3.zhimg.com/v2-a36308ba92ad0bad9a4223a8a17004b2.jpg"],"type":0,"id":9625697,"ga_prefix":"092216","title":"阴天去超市买雨伞，会比晴天更便宜，这是为什么？"},{"images":["https://pic1.zhimg.com/v2-2b5e85648774e12685639f96b9760e2c.jpg"],"type":0,"id":9626958,"ga_prefix":"092215","title":"HTC 押宝 VR，Google 心思不在手机上，这场收购还是达成了"},{"images":["https://pic1.zhimg.com/v2-8865056a86b35ed0dc9307b45d4dcab4.jpg"],"type":0,"id":9623927,"ga_prefix":"092214","title":"问个问题：你觉得自己是对称的吗？"},{"images":["https://pic4.zhimg.com/v2-8d11c40fc22ea92e961261f238898f9b.jpg"],"type":0,"id":9626390,"ga_prefix":"092213","title":"每次看打戏都替主角感到疼，他们是真的在打还是做样子？"},{"images":["https://pic2.zhimg.com/v2-06b6eab7972327d3dd41896cc195ad39.jpg"],"type":0,"id":9625630,"ga_prefix":"092212","title":"大误 · 大家好，我们抢先体验了这款新游戏"},{"images":["https://pic3.zhimg.com/v2-1d1d4faa802aa9483c106748f811077e.jpg"],"type":0,"id":9626441,"ga_prefix":"092211","title":"iPhone 的价格是不是真的越来越贵？"},{"images":["https://pic2.zhimg.com/v2-70911069c435d43e6a72dcb0b82c590d.jpg"],"type":0,"id":9625393,"ga_prefix":"092210","title":"搜查宿舍、没收违禁电器，学校真的有权利对我做这些吗？"},{"images":["https://pic3.zhimg.com/v2-fbcc987cdb97f8e1859768945dbc4032.jpg"],"type":0,"id":9625444,"ga_prefix":"092209","title":"现实中的猩猩，是不是真的跟人一样存在着「文化」？"},{"images":["https://pic2.zhimg.com/v2-0c5475d56e9cca912f1a75056ee6e2f1.jpg"],"type":0,"id":3947050,"ga_prefix":"092208","title":"- 我们升级了全新硬件，虽然外表看不出来\r\n- 好的，不买"},{"images":["https://pic1.zhimg.com/v2-9fc6920af0087ab3db94ab47c3f7f260.jpg"],"type":0,"id":9621569,"ga_prefix":"092207","title":"首次办比赛就吸引到两大天王并肩出战，这个周末就看它了"},{"images":["https://pic1.zhimg.com/v2-3ec07817ea4cc7b1f57066d8426e05d0.jpg"],"type":0,"id":9626463,"ga_prefix":"092207","title":"我们在全国做了精神卫生调查，发现真实状况令人担忧"},{"images":["https://pic2.zhimg.com/v2-f3b974264dcb13bf56099126785afcf1.jpg"],"type":0,"id":9625570,"ga_prefix":"092207","title":"2017 年，观察到了一个有意思的消费升级现象"},{"images":["https://pic1.zhimg.com/v2-3e5331c27e27f31824bc9c239d1f1988.jpg"],"type":0,"id":9624986,"ga_prefix":"092206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-cb2054d80d8591d2ac67a016fbb6288b.jpg","type":0,"id":9627209,"ga_prefix":"092219","title":"马化腾表情包的背后"},{"image":"https://pic4.zhimg.com/v2-226bcf07ab0a6db65502d04579a35ba7.jpg","type":0,"id":9626958,"ga_prefix":"092215","title":"HTC 押宝 VR，Google 心思不在手机上，这场收购还是达成了"},{"image":"https://pic4.zhimg.com/v2-85d14a6eac03a8d2d0152a25a155bf87.jpg","type":0,"id":9624559,"ga_prefix":"092218","title":"隔两分钟就忍不住拿起手机\u2026\u2026怎么才能静下心来做事？"},{"image":"https://pic3.zhimg.com/v2-6cbe6e0e6f242c5624bf4303a8d66382.jpg","type":0,"id":9625444,"ga_prefix":"092209","title":"现实中的猩猩，是不是真的跟人一样存在着「文化」？"},{"image":"https://pic3.zhimg.com/v2-9c1568aa03ca151eea4a587ee51802ea.jpg","type":0,"id":9626463,"ga_prefix":"092207","title":"我们在全国做了精神卫生调查，发现真实状况令人担忧"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-d49927983b0664ecc37641ff05fc5fc3.jpg"]
         * type : 0
         * id : 9624093
         * ga_prefix : 092220
         * title : 承认吧，所谓读书，就是纪录一本书的拥有过程给别人看
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public List<String> images;
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-cb2054d80d8591d2ac67a016fbb6288b.jpg
         * type : 0
         * id : 9627209
         * ga_prefix : 092219
         * title : 马化腾表情包的背后
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}

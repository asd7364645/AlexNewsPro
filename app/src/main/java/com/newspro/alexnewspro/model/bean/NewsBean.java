package com.newspro.alexnewspro.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsBean implements Parcelable{

    private ResultBean result;
    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"title":"农村新郎接新娘回家，推开门的那一刻傻眼了","date":"2016-12-26 09:10","author_name":"行走的乡村","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20161226/20161226091025_ff22c52ef8cdc955f57ea743d009dd5d_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20161226/20161226091025_ff22c52ef8cdc955f57ea743d009dd5d_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20161226/20161226091025_ff22c52ef8cdc955f57ea743d009dd5d_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226091025506.html?qid=juheshuju","uniquekey":"161226091025506","type":"头条","realtype":"社会"},{"title":"汉丽轩自助\"鸭肉变牛肉\" 工作人员:骗过了全世界","date":"2016-12-26 06:54","author_name":"网易","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20161226/20161226065428_906422a95de262a92d2a57aa7507670d_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20161226/20161226065428_906422a95de262a92d2a57aa7507670d_1_mwpl_05500201.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20161226/20161226065428_906422a95de262a92d2a57aa7507670d_1_mwpl_05500201.jpg","url":"http://mini.eastday.com/mobile/161226065428778.html?qid=juheshuju","uniquekey":"161226065428778","type":"头条","realtype":"社会"},{"title":"白天在班上挨打晚上在宿舍受气 屡遭同学欺负吞铁钉欲自杀","date":"2016-12-26 08:37","author_name":"中国江西网","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20161226/20161226083726_de9c8c22dcd2f1063f51e2e715e74b8d_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20161226/20161226083726_de9c8c22dcd2f1063f51e2e715e74b8d_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20161226/20161226083726_de9c8c22dcd2f1063f51e2e715e74b8d_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226083726105.html?qid=juheshuju","uniquekey":"161226083726105","type":"头条","realtype":"社会"},{"title":"14岁女孩谋杀生父一枪爆头 美国民众呼吁将其释放","date":"2016-12-26 00:50","author_name":"东方头条","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161226/20161226005025_2ba3fa3852ce7ec1b93067177c5cf572_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20161226/20161226005025_2ba3fa3852ce7ec1b93067177c5cf572_1_mwpl_05500201.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161226/20161226005025_2ba3fa3852ce7ec1b93067177c5cf572_1_mwpl_05500201.jpg","url":"http://mini.eastday.com/mobile/161226005025246.html?qid=juheshuju","uniquekey":"161226005025246","type":"头条","realtype":"社会"},{"title":"明年农村低保将会上涨，但这些人会被清退低保！","date":"2016-12-26 09:49","author_name":"三农八卦","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161226/20161226_ddba63234e505f9b7e9ecd6e62efb3d7_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20161226/20161226_ddba63234e505f9b7e9ecd6e62efb3d7_cover_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161226/20161226_ddba63234e505f9b7e9ecd6e62efb3d7_cover_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226094924193.html?qid=juheshuju","uniquekey":"161226094924193","type":"头条","realtype":"社会"},{"title":"土豆你还在炒着吃，教你一招做出的土豆比炒着好吃一百倍！","date":"2016-12-26 05:28","author_name":"如果你是吃货","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20161226/20161226052809_092ad52933030940917e2c0c4bac0a50_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20161226/20161226052809_092ad52933030940917e2c0c4bac0a50_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20161226/20161226052809_092ad52933030940917e2c0c4bac0a50_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226052809017.html?qid=juheshuju","uniquekey":"161226052809017","type":"头条","realtype":"健康"},{"title":"苏35交付解放军后能否对付日本F35：情况十分不乐观","date":"2016-12-26 10:08","author_name":"新浪军事","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20161226/20161226100848_b48c2b4e03ded25ff8a738e27471da1e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20161226/20161226100848_b48c2b4e03ded25ff8a738e27471da1e_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20161226/20161226100848_b48c2b4e03ded25ff8a738e27471da1e_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226100848496.html?qid=juheshuju","uniquekey":"161226100848496","type":"头条","realtype":"军事"},{"title":"流浪乞丐在街头讨钱，然而下一幕，却让人感到非常气愤！","date":"2016-12-26 11:03","author_name":"今日情感头条","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20161226/20161226_1daf3b6add058542e92cdbfbc506d988_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20161226/20161226_1daf3b6add058542e92cdbfbc506d988_mwpl_05500201.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20161226/20161226_1daf3b6add058542e92cdbfbc506d988_mwpl_05500201.jpg","url":"http://mini.eastday.com/mobile/161226110311485.html?qid=juheshuju","uniquekey":"161226110311485","type":"头条","realtype":"社会"},{"title":"临时夫妻，工地成为重灾区，不受法律的爱是否长久！","date":"2016-12-26 03:45","author_name":"老表喷八卦","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161226/20161226034520_d1b564629979a00facda41913ae6bd74_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20161226/20161226034520_d1b564629979a00facda41913ae6bd74_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161226/20161226034520_d1b564629979a00facda41913ae6bd74_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226034520370.html?qid=juheshuju","uniquekey":"161226034520370","type":"头条","realtype":"娱乐"},{"title":"美称中俄两国海军联手都不是其对手，英专家一语戳破牛皮","date":"2016-12-26 10:21","author_name":"军旅人生","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161226/20161226102149_4e1da618786dc83f48fccb354038f516_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20161226/20161226102149_4e1da618786dc83f48fccb354038f516_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161226/20161226102149_4e1da618786dc83f48fccb354038f516_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226102149653.html?qid=juheshuju","uniquekey":"161226102149653","type":"头条","realtype":"军事"},{"title":"男子开挖掘机砸烂银行ATM盗窃现金：结果悲剧了","date":"2016-12-25 18:17","author_name":"环球网","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20161225/20161225181741_58ad28bfd90b1e05802a32ca382ffa15_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20161225/20161225181741_58ad28bfd90b1e05802a32ca382ffa15_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20161225/20161225181741_58ad28bfd90b1e05802a32ca382ffa15_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161225181741509.html?qid=juheshuju","uniquekey":"161225181741509","type":"头条","realtype":"社会"},{"title":"英媒：津巴布韦将30头大象运往中国野生动物园卖钱","date":"2016-12-26 11:07","author_name":"环球网","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161226/20161226110734_f400541d53be64802442a5beaff2000e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20161226/20161226110734_f400541d53be64802442a5beaff2000e_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161226/20161226110734_f400541d53be64802442a5beaff2000e_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226110734517.html?qid=juheshuju","uniquekey":"161226110734517","type":"头条","realtype":"国际"},{"title":"山东巨野现警方查车震视频泄露 回应:辅警干的","date":"2016-12-26 08:50","author_name":"北京时间","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20161226/20161226085041_6c5e9cc4f2c526ead247e83e7de0628e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20161226/20161226085041_6c5e9cc4f2c526ead247e83e7de0628e_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20161226/20161226085041_6c5e9cc4f2c526ead247e83e7de0628e_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226085041215.html?qid=juheshuju","uniquekey":"161226085041215","type":"头条","realtype":"社会"},{"title":"\u201c黄流\u201d阻击者：残疾人志愿参与 鉴黄师每天审5千张图","date":"2016-12-26 10:53","author_name":"央视网","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161226/20161226105317_50305ddfec3e44af6e684a1a6e8da27a_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20161226/20161226105317_50305ddfec3e44af6e684a1a6e8da27a_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161226/20161226105317_50305ddfec3e44af6e684a1a6e8da27a_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226105317041.html?qid=juheshuju","uniquekey":"161226105317041","type":"头条","realtype":"社会"},{"title":"农村危房改造对象将发生大变化！这些人不能申请！","date":"2016-12-26 10:22","author_name":"三农八卦","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20161226/20161226_6c908d1acc2aa06689b67537a363899f_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20161226/20161226_6c908d1acc2aa06689b67537a363899f_cover_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20161226/20161226_6c908d1acc2aa06689b67537a363899f_cover_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226102246520.html?qid=juheshuju","uniquekey":"161226102246520","type":"头条","realtype":"社会"},{"title":"死里逃生 俄罗斯歌舞团成员因护照过期逃过一劫","date":"2016-12-26 10:03","author_name":"看看新闻Knews","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20161226/20161226100336_2e445d8eb3dd2a1e084a83b04b99c07f_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20161226/20161226100336_2e445d8eb3dd2a1e084a83b04b99c07f_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20161226/20161226100336_2e445d8eb3dd2a1e084a83b04b99c07f_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226100336191.html?qid=juheshuju","uniquekey":"161226100336191","type":"头条","realtype":"国际"},{"title":"凯特王妃一家赴教堂 乔治和妹妹的表情亮了 ","date":"2016-12-26 09:37","author_name":"腾讯娱乐","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20161226/20161226093710_43b1a7aef2f32471fa0efabda809d713_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20161226/20161226093710_43b1a7aef2f32471fa0efabda809d713_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20161226/20161226093710_43b1a7aef2f32471fa0efabda809d713_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226093710758.html?qid=juheshuju","uniquekey":"161226093710758","type":"头条","realtype":"娱乐"},{"title":"赵薇与希拉里私交甚密，豪车载马云出席活动，吞云吐雾十足老烟枪","date":"2016-12-26 10:25","author_name":"心动文娱","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161226/20161226_f9f75c5c4172744c40214f7732e4431f_cover_mwpm_03200403.png","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20161226/20161226_f9f75c5c4172744c40214f7732e4431f_cover_mwpl_05500201.png","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161226/20161226_f9f75c5c4172744c40214f7732e4431f_cover_mwpl_05500201.png","url":"http://mini.eastday.com/mobile/161226102521998.html?qid=juheshuju","uniquekey":"161226102521998","type":"头条","realtype":"娱乐"},{"title":"德国南部惊现巨型炸弹 5.4万人圣诞节期间撤离","date":"2016-12-26 11:24","author_name":"中国日报网","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20161226/20161226112438_623f952916fef1bf188cdb0940510a09_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20161226/20161226112438_623f952916fef1bf188cdb0940510a09_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20161226/20161226112438_623f952916fef1bf188cdb0940510a09_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226112438148.html?qid=juheshuju","uniquekey":"161226112438148","type":"头条","realtype":"国际"},{"title":"这秘书是不是穿的少点什么了","date":"2016-12-26 09:06","author_name":"麦克","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20161226/20161226_829fb735622c5019fcb7917fba34265b_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20161226/20161226_829fb735622c5019fcb7917fba34265b_cover_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20161226/20161226_829fb735622c5019fcb7917fba34265b_cover_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226090639867.html?qid=juheshuju","uniquekey":"161226090639867","type":"头条","realtype":"笑话"},{"title":"专家：不久将可实现机器人与人发生性行为","date":"2016-12-26 06:57","author_name":"环球网","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161226/20161226065711_c40f0f2f41adae3144fa7336302d7cd0_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20161226/20161226065711_c40f0f2f41adae3144fa7336302d7cd0_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161226/20161226065711_c40f0f2f41adae3144fa7336302d7cd0_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226065711822.html?qid=juheshuju","uniquekey":"161226065711822","type":"头条","realtype":"科技"},{"title":"挡风遮阳还能给手机充电 这太阳能沙滩椅不断电","date":"2016-12-26 10:51","author_name":"腾讯数码","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161226/20161226105140_71b0de3a6d803735efcbbd8486ad2ae6_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20161226/20161226105140_71b0de3a6d803735efcbbd8486ad2ae6_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161226/20161226105140_71b0de3a6d803735efcbbd8486ad2ae6_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226105140172.html?qid=juheshuju","uniquekey":"161226105140172","type":"头条","realtype":"科技"},{"title":"两高出台司法解释 明确污染环境罪定罪量刑具体标准","date":"2016-12-26 10:43","author_name":"中国新闻网","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20161226/20161226104310_82eec166be9d40e51b71ed3203694f37_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20161226/20161226104310_82eec166be9d40e51b71ed3203694f37_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20161226/20161226104310_82eec166be9d40e51b71ed3203694f37_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226104310758.html?qid=juheshuju","uniquekey":"161226104310758","type":"头条","realtype":"国内"},{"title":"今天 我们一起缅怀伟人毛泽东","date":"2016-12-26 09:15","author_name":"人民日报","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161226/20161226091524_4e2dce8dba3f371de6eb6ba3cbeca3e3_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20161226/20161226091524_4e2dce8dba3f371de6eb6ba3cbeca3e3_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161226/20161226091524_4e2dce8dba3f371de6eb6ba3cbeca3e3_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226091524078.html?qid=juheshuju","uniquekey":"161226091524078","type":"头条","realtype":"国内"},{"title":"贾玲安静时就是一枚美女子 霸气与柔情并存","date":"2016-12-26 08:06","author_name":"腾讯娱乐","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20161226/20161226080619_5feebc4416ce2237fd9298df7cebab71_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20161226/20161226080619_5feebc4416ce2237fd9298df7cebab71_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20161226/20161226080619_5feebc4416ce2237fd9298df7cebab71_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226080619447.html?qid=juheshuju","uniquekey":"161226080619447","type":"头条","realtype":"娱乐"},{"title":"俄罗斯坠毁军机上的国宝：全是美女帅哥 ","date":"2016-12-26 11:04","author_name":"军事新观察","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20161226/20161226110441_3bcc6c18a03328849edd24eb9e081e5e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20161226/20161226110441_3bcc6c18a03328849edd24eb9e081e5e_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20161226/20161226110441_3bcc6c18a03328849edd24eb9e081e5e_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226110441274.html?qid=juheshuju","uniquekey":"161226110441274","type":"头条","realtype":"军事"},{"title":"陌生男子潜入南京某小学，欲把女生带入空教室","date":"2016-12-26 07:40","author_name":"扬子晚报","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20161226/20161226074000_3f9141bae0dfcb7eb2337a994c374104_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20161226/20161226074000_3f9141bae0dfcb7eb2337a994c374104_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20161226/20161226074000_3f9141bae0dfcb7eb2337a994c374104_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226074000655.html?qid=juheshuju","uniquekey":"161226074000655","type":"头条","realtype":"社会"},{"title":"7张实拍照直击俄罗斯最漂亮的柔软女孩","date":"2016-12-26 08:56","author_name":"图看世界","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161226/20161226_8103a59b28d3522b8f09fa2517fe7bee_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20161226/20161226_8103a59b28d3522b8f09fa2517fe7bee_mwpl_05500201.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161226/20161226_8103a59b28d3522b8f09fa2517fe7bee_mwpl_05500201.jpg","url":"http://mini.eastday.com/mobile/161226085624078.html?qid=juheshuju","uniquekey":"161226085624078","type":"头条","realtype":"国际"},{"title":"三星S7降幅已达1300 行货仅售3588元","date":"2016-12-26 10:37","author_name":"腾讯数码","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161226/20161226103750_43305a97779134d4889e1570207fe812_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20161226/20161226103750_43305a97779134d4889e1570207fe812_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161226/20161226103750_43305a97779134d4889e1570207fe812_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226103750766.html?qid=juheshuju","uniquekey":"161226103750766","type":"头条","realtype":"科技"},{"title":"国家外汇管理局：\u201c蚂蚁搬家\u201d一律进入黑名单！","date":"2016-12-26 10:37","author_name":"云核变量金融交易员","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161226/20161226103726_41459cc63eab1ed58bd644b43aa72617_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20161226/20161226103726_41459cc63eab1ed58bd644b43aa72617_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161226/20161226103726_41459cc63eab1ed58bd644b43aa72617_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226103726338.html?qid=juheshuju","uniquekey":"161226103726338","type":"头条","realtype":"财经"},{"title":"讲武谈兵丨中国反隐身雷达如何在东海打破F-22A的神话？","date":"2016-12-26 10:20","author_name":"澎湃新闻","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20161226/20161226102057_8cb707ac70d117a897112d2a39cdefad_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20161226/20161226102057_8cb707ac70d117a897112d2a39cdefad_1_mwpl_05500201.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20161226/20161226102057_8cb707ac70d117a897112d2a39cdefad_1_mwpl_05500201.jpeg","url":"http://mini.eastday.com/mobile/161226102057574.html?qid=juheshuju","uniquekey":"161226102057574","type":"头条","realtype":"军事"}]}
     * error_code : 0
     */

    private int error_code;

    protected NewsBean(Parcel in) {
        error_code = in.readInt();
    }

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel in) {
            return new NewsBean(in);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(error_code);
    }

    public static class ResultBean implements Parcelable{
        private String stat;
        /**
         * title : 农村新郎接新娘回家，推开门的那一刻傻眼了
         * date : 2016-12-26 09:10
         * author_name : 行走的乡村
         * thumbnail_pic_s : http://05.imgmini.eastday.com/mobile/20161226/20161226091025_ff22c52ef8cdc955f57ea743d009dd5d_1_mwpm_03200403.jpeg
         * thumbnail_pic_s02 : http://05.imgmini.eastday.com/mobile/20161226/20161226091025_ff22c52ef8cdc955f57ea743d009dd5d_1_mwpl_05500201.jpeg
         * thumbnail_pic_s03 : http://05.imgmini.eastday.com/mobile/20161226/20161226091025_ff22c52ef8cdc955f57ea743d009dd5d_1_mwpl_05500201.jpeg
         * url : http://mini.eastday.com/mobile/161226091025506.html?qid=juheshuju
         * uniquekey : 161226091025506
         * type : 头条
         * realtype : 社会
         */

        private List<DataBean> data;

        protected ResultBean(Parcel in) {
            stat = in.readString();
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel in) {
                return new ResultBean(in);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(stat);
        }

        public static class DataBean implements Parcelable{
            private String title;
            private String date;
            private String author_name;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;
            private String url;
            private String uniquekey;
            private String type;
            private String realtype;

            protected DataBean(Parcel in) {
                title = in.readString();
                date = in.readString();
                author_name = in.readString();
                thumbnail_pic_s = in.readString();
                thumbnail_pic_s02 = in.readString();
                thumbnail_pic_s03 = in.readString();
                url = in.readString();
                uniquekey = in.readString();
                type = in.readString();
                realtype = in.readString();
            }

            public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
                @Override
                public DataBean createFromParcel(Parcel in) {
                    return new DataBean(in);
                }

                @Override
                public DataBean[] newArray(int size) {
                    return new DataBean[size];
                }
            };

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRealtype() {
                return realtype;
            }

            public void setRealtype(String realtype) {
                this.realtype = realtype;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(title);
                dest.writeString(date);
                dest.writeString(author_name);
                dest.writeString(thumbnail_pic_s);
                dest.writeString(thumbnail_pic_s02);
                dest.writeString(thumbnail_pic_s03);
                dest.writeString(url);
                dest.writeString(uniquekey);
                dest.writeString(type);
                dest.writeString(realtype);
            }
        }
    }
}

-- ----------------------------
-- Table structure for MEMBER(会员表)
-- ----------------------------
DROP TABLE "MEMBER";
CREATE TABLE "MEMBER" (
"MEMBERID" VARCHAR2(32 BYTE) NOT NULL ,
"MERCHANTID" VARCHAR2(32 BYTE) NULL ,
"MEMBEROPENID" VARCHAR2(50 BYTE) NULL ,
"MEMBERNAME" VARCHAR2(50 BYTE) NULL ,
"MEMBERSEX" VARCHAR2(1 BYTE) NULL ,
"MEMBERBIRTHDAY" VARCHAR2(10 BYTE) NULL ,
"MEMBERPHONE" VARCHAR2(11 BYTE) NULL ,
"MEMBERYZM" VARCHAR2(10 BYTE) NULL ,
"MEMBERGRADE" VARCHAR2(2 BYTE) NULL ,
"MEMBERSQSJ" TIMESTAMP(6)  NULL ,
"BZ" VARCHAR2(600 BYTE) NULL 
);

ALTER TABLE "MEMBER" ADD PRIMARY KEY ("MEMBERID");

COMMENT ON COLUMN "MEMBER"."MEMBERID" IS '会员ID';
COMMENT ON COLUMN "MEMBER"."MERCHANTID" IS '商家ID';
COMMENT ON COLUMN "MEMBER"."MEMBEROPENID" IS '会员针对商家公众号的OPENID';
COMMENT ON COLUMN "MEMBER"."MEMBERNAME" IS '会员姓名';
COMMENT ON COLUMN "MEMBER"."MEMBERSEX" IS '会员性别';
COMMENT ON COLUMN "MEMBER"."MEMBERBIRTHDAY" IS '会员生日';
COMMENT ON COLUMN "MEMBER"."MEMBERPHONE" IS '会员手机号';
COMMENT ON COLUMN "MEMBER"."MEMBERYZM" IS '会员验证码';
COMMENT ON COLUMN "MEMBER"."MEMBERGRADE" IS '会员级别';
COMMENT ON COLUMN "MEMBER"."MEMBERSQSJ" IS '会员申请时间';
COMMENT ON COLUMN "MEMBER"."BZ" IS '备注信息';

-- ----------------------------
-- Table structure for MEMBERCARD(会员卡)
-- ----------------------------
DROP TABLE "MEMBERCARD";
CREATE TABLE "MEMBERCARD" (
"MERBERCARDID" VARCHAR2(32 BYTE) NOT NULL ,
"MEMBERID" VARCHAR2(32 BYTE) NULL ,
"MERCHANTID" VARCHAR2(32 BYTE) NULL ,
"CARDNO" VARCHAR2(50 BYTE) NULL ,
"DZCARDNO" VARCHAR2(50 BYTE) NULL ,
"CARDGRADE" VARCHAR2(2 BYTE) NULL ,
"CARDCODE" VARCHAR2(100 BYTE) NULL ,
"CARDSTAT" VARCHAR2(2 BYTE) NULL ,
"CARDSQSJ" TIMESTAMP(6)  NULL ,
"CARDMODE" VARCHAR2(2 BYTE) NULL ,
"BZ" VARCHAR2(600 BYTE) NULL,
"cardname" varchar2(100) not null
);

ALTER TABLE "MEMBERCARD" ADD PRIMARY KEY ("MERBERCARDID");

COMMENT ON TABLE "MEMBERCARD" IS '会员卡信息表';
COMMENT ON COLUMN "MEMBERCARD"."MERBERCARDID" IS '会员卡ID，主键';
COMMENT ON COLUMN "MEMBERCARD"."MEMBERID" IS '会员ID';
COMMENT ON COLUMN "MEMBERCARD"."MERCHANTID" IS '商家ID';
COMMENT ON COLUMN "MEMBERCARD"."CARDNO" IS '会员卡号（预付卡系统后台实体卡号）';
COMMENT ON COLUMN "MEMBERCARD"."DZCARDNO" IS '电子卡号（预付卡系统后台电子卡号）';
COMMENT ON COLUMN "MEMBERCARD"."CARDGRADE" IS '会员卡等级';
COMMENT ON COLUMN "MEMBERCARD"."CARDCODE" IS '会员卡二维码信息';
COMMENT ON COLUMN "MEMBERCARD"."CARDSTAT" IS '卡状态';
COMMENT ON COLUMN "MEMBERCARD"."CARDSQSJ" IS '申请会员卡时间';
COMMENT ON COLUMN "MEMBERCARD"."CARDMODE" IS '申请会员卡方式(申请新卡或绑定旧卡)';
COMMENT ON COLUMN "MEMBERCARD"."BZ" IS '备注信息';
COMMENT ON COLUMN "membercard"."cardname" IS '会员卡名称';


-- ----------------------------
-- Table structure for MERCHANT(商家)
-- ----------------------------
DROP TABLE "MERCHANT";
CREATE TABLE "MERCHANT" (
"MERCHANTID" VARCHAR2(32 BYTE) NOT NULL ,
"WEAPPID" VARCHAR2(50 BYTE) NOT NULL ,
"WENAME" VARCHAR2(300 BYTE) NOT NULL ,
"TOKEN" VARCHAR2(50 BYTE) NOT NULL ,
"APPID" VARCHAR2(50 BYTE) NOT NULL ,
"APPSECRET" VARCHAR2(80 BYTE) NOT NULL ,
"MERCHANTNAME" VARCHAR2(90 BYTE) NOT NULL ,
"MERCHANTCONTACT" VARCHAR2(30 BYTE) NOT NULL ,
"MERCHANTPHONE" VARCHAR2(11 BYTE) NULL ,
"MERCHANTADDR" VARCHAR2(600 BYTE) NULL ,
"BZ" VARCHAR2(3000 BYTE) NULL ,
"URLFLAG" VARCHAR2(10 BYTE) NOT NULL ,
"UPDATETIME" TIMESTAMP(6)  DEFAULT sysdate  NOT NULL 
);

ALTER TABLE "MERCHANT" ADD PRIMARY KEY ("MERCHANTID");

COMMENT ON TABLE "MERCHANT" IS '商家表';
COMMENT ON COLUMN "MERCHANT"."MERCHANTID" IS '商家ID';
COMMENT ON COLUMN "MERCHANT"."WEAPPID" IS '商家公众号';
COMMENT ON COLUMN "MERCHANT"."WENAME" IS '商家公众号名称';
COMMENT ON COLUMN "MERCHANT"."TOKEN" IS 'Token令牌';
COMMENT ON COLUMN "MERCHANT"."APPID" IS 'AppID应用ID';
COMMENT ON COLUMN "MERCHANT"."APPSECRET" IS 'AppSecret应用密钥';
COMMENT ON COLUMN "MERCHANT"."MERCHANTNAME" IS '商户名';
COMMENT ON COLUMN "MERCHANT"."MERCHANTCONTACT" IS '商户联系人';
COMMENT ON COLUMN "MERCHANT"."MERCHANTPHONE" IS '商户手机号';
COMMENT ON COLUMN "MERCHANT"."MERCHANTADDR" IS '商户联系地址';
COMMENT ON COLUMN "MERCHANT"."BZ" IS '备注';
COMMENT ON COLUMN "MERCHANT"."URLFLAG" IS 'URL标识';
COMMENT ON COLUMN "MERCHANT"."UPDATETIME" IS '更新时间';


-- ----------------------------
-- Table structure for SELECTOPTIONS(多级字典)
-- ----------------------------
DROP TABLE "SELECTOPTIONS";
CREATE TABLE "SELECTOPTIONS" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"ITEMTYPE" VARCHAR2(30 BYTE) NOT NULL ,
"ITEMNAME" VARCHAR2(60 BYTE) NOT NULL ,
"ITEMCODE" VARCHAR2(30 BYTE) NOT NULL ,
"ITEMVALUE" VARCHAR2(60 BYTE) NOT NULL ,
"ORDERNUM" NUMBER(5) NOT NULL ,
"BZ" VARCHAR2(600 BYTE) NULL 
);

ALTER TABLE "SELECTOPTIONS" ADD PRIMARY KEY ("ID");

COMMENT ON TABLE "SELECTOPTIONS" IS '多级字典表';
COMMENT ON COLUMN "SELECTOPTIONS"."ID" IS '主键';
COMMENT ON COLUMN "SELECTOPTIONS"."ITEMTYPE" IS '字典类型';
COMMENT ON COLUMN "SELECTOPTIONS"."ITEMNAME" IS '字典名称';
COMMENT ON COLUMN "SELECTOPTIONS"."ITEMCODE" IS '编码';
COMMENT ON COLUMN "SELECTOPTIONS"."ITEMVALUE" IS '名称';
COMMENT ON COLUMN "SELECTOPTIONS"."ORDERNUM" IS '排序号';
COMMENT ON COLUMN "SELECTOPTIONS"."BZ" IS '备注';

-- ----------------------------
-- Table structure for PARAMETER(参数)
-- ----------------------------
DROP TABLE "PARAMETER";
CREATE TABLE "PARAMETER" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"PARAMCODE" VARCHAR2(50 BYTE) NOT NULL ,
"PARAMVALUE" VARCHAR2(60 BYTE) NOT NULL ,
"PARAMNAME" VARCHAR2(90 BYTE) NOT NULL ,
"BZ" VARCHAR2(600 BYTE) NULL ,
"UPDATETIME" TIMESTAMP(6)  DEFAULT sysdate  NULL 
);

ALTER TABLE "PARAMETER" ADD PRIMARY KEY ("ID");

COMMENT ON TABLE "PARAMETER" IS '参数表';
COMMENT ON COLUMN "PARAMETER"."ID" IS '主键';
COMMENT ON COLUMN "PARAMETER"."PARAMCODE" IS '参数代码';
COMMENT ON COLUMN "PARAMETER"."PARAMVALUE" IS '参数值';
COMMENT ON COLUMN "PARAMETER"."PARAMNAME" IS '参数名称';
COMMENT ON COLUMN "PARAMETER"."BZ" IS '备注';
COMMENT ON COLUMN "PARAMETER"."UPDATETIME" IS '更新时间';

-- ----------------------------
-- Table structure for COUPON
-- ----------------------------
DROP TABLE "COUPON";
CREATE TABLE "COUPON" (
"COUPONID" VARCHAR2(32 BYTE) NOT NULL ,
"MEMBERID" VARCHAR2(32 BYTE) NULL ,
"MERCHANTCOUPONID" VARCHAR2(32 BYTE) NULL ,
"MERCHANTID" VARCHAR2(32 BYTE) NULL ,
"MEMBERCOUPONSTATE" VARCHAR2(2 BYTE) NULL ,
"COUPONCODE" VARCHAR2(1000 BYTE) NULL ,
"COUPONSJ" TIMESTAMP(6)  NULL ,
"BZ" VARCHAR2(1000 BYTE) NULL,
"starttime" date not null,
"endtime" data not null,
"couponname" not null,
"coupontype" varchar2(2) NOT NULL,
);

ALTER TABLE "COUPON" ADD PRIMARY KEY ("COUPONID");

COMMENT ON TABLE "COUPON" IS '优惠券信息表';
COMMENT ON COLUMN "COUPON"."COUPONID" IS '会员优惠券标识,主键';
COMMENT ON COLUMN "COUPON"."MEMBERID" IS '会员ID';
COMMENT ON COLUMN "COUPON"."MERCHANTCOUPONID" IS '商家优惠券ID';
COMMENT ON COLUMN "COUPON"."MERCHANTID" IS '商家ID（冗余，供查询方便用）';
COMMENT ON COLUMN "COUPON"."MEMBERCOUPONSTATE" IS '优惠券状态';
COMMENT ON COLUMN "COUPON"."COUPONCODE" IS '优惠券的二维码信息';
COMMENT ON COLUMN "COUPON"."COUPONSJ" IS '申领优惠券时间';
COMMENT ON COLUMN "COUPON"."BZ" IS '备注信息';
COMMENT ON COLUMN "COUPON"."starttime" IS '优惠券的有效开始时间';
COMMENT ON COLUMN "COUPON"."endtime" IS '优惠券的有效结束时间';
COMMENT ON COLUMN "COUPON"."couponname" IS '优惠券名称';
COMMENT ON COLUMN "COUPON"."coupontype" IS '优惠券类别';

-- 商家优惠券信息
DROP TABLE merchantcoupon;
CREATE TABLE merchantcoupon
(
merchantcouponid varchar2(32),
merchantid varchar2(32),
couponclass varchar2(2),
couponvalid varchar2(50),
couponkssj varchar2(50),
couponjssj varchar2(50),
couponcontent varchar2(1000),
merchantcouponstate varchar2(2),
bz varchar2(1000),
couponname varchar(100),
coupontype varchar2(2),
primary key(merchantcouponid,merchantid)
);

-- 注释
comment on column merchantcoupon.merchantcouponid IS '商家优惠券ID，主键';
comment on column merchantcoupon.merchantid IS '商家ID，主键';
comment on column merchantcoupon.couponclass IS '优惠券分类';
comment on column merchantcoupon.couponvalid IS '优惠券有效期';
comment on column merchantcoupon.couponkssj IS '优惠券有效期的起始时间';
comment on column merchantcoupon.couponjssj IS '优惠券有效期的结束时间';
comment on column merchantcoupon.couponcontent IS '商家优惠券内容';
comment on column merchantcoupon.merchantcouponstate IS '优惠券状态';
comment on column merchantcoupon.bz IS '备注信息';
comment on column merchantcoupon.couponname IS '优惠券名称';
comment on column merchantcoupon.coupontype IS '优惠券类别';


-- 会员卡充值记录表
CREATE TABLE recharge
(
rechargeid varchar2(32),
membercardid varchar2(32),
accountid varchar2(32),
memberid  varchar2(32),
merchantid varchar2(32),
rechargenum number(16,2),
rechargemode varchar2(2),
rechargesj timestamp,
rechargecode varchar2(10),
bz varchar2(1000)
);

-- 注释
comment on column recharge.rechargeid IS '标识ID';
comment on column recharge.membercardid IS '会员卡ID';
comment on column recharge.accountid IS '账户ID';
comment on column recharge.memberid  IS '会员ID';
comment on column recharge.merchantid IS '商家ID';
comment on column recharge.rechargenum IS '充值金额';
comment on column recharge.rechargemode IS '充值方式';
comment on column recharge.rechargesj IS '充值时间';
comment on column recharge.rechargecode IS '返回码';
comment on column recharge.bz IS '备注信息';

-- 初始化数据
INSERT INTO SELECTOPTIONS VALUES ('b147ddb9d1074070ab9534ac86498767', '1002', '性别', '1', '男', '1', null);
INSERT INTO SELECTOPTIONS VALUES ('2c8aa116b5e64292ae215993798f66e9', '1002', '性别', '2', '女', '2', null);
INSERT INTO SELECTOPTIONS VALUES ('28538fc1de664b99ac979dbe956edcec', '1004', '优惠券状态', '01', '已领用', '2', null);
INSERT INTO SELECTOPTIONS VALUES ('c0691f91ae5341de92b330625b86944d', '1004', '优惠券状态', '02', '已使用', '3', null);
INSERT INTO SELECTOPTIONS VALUES ('56fd463e00be409e8fe522a39923e83c', '1004', '优惠券状态', '03', '已过期', '4', null);
INSERT INTO SELECTOPTIONS VALUES ('df92a524edf4445b998e9e450f2df5b5', '1005', '优惠券类别', '01', '现金券', '1', null);
INSERT INTO SELECTOPTIONS VALUES ('796a18c5e6e9449da254ca7cbd682199', '1005', '优惠券类别', '02', '折扣券', '2', null);
INSERT INTO SELECTOPTIONS VALUES ('fa8b4a2b1e1f47e98489a32b919c72be', '1005', '优惠券类别', '03', '实物券', '3', null);
INSERT INTO SELECTOPTIONS VALUES ('3be52ec3f5ed4c6c817e38b08682e927', '1004', '优惠券状态', '00', '未领用', '4', null);
INSERT INTO SELECTOPTIONS VALUES ('9667d801bdde4da2b15ea3777d465d81', '1003', '会员级别', '01', '普通会员', '1', null);
INSERT INTO SELECTOPTIONS VALUES ('6146513cafed4acca6c8e9635630c261', '1001', '卡类型', '01', '申请新卡', '1', null);
INSERT INTO SELECTOPTIONS VALUES ('d6459e61c9104584b94a2f7dd070aad5', '1001', '卡类型', '02', '绑定旧卡', '2', null);
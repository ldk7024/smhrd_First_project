-- 생성자 Oracle SQL Developer Data Modeler 20.4.1.406.0906
--   위치:        2021-04-24 16:39:04 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE
drop table customer cascade constraint;
drop table production cascade constraint;
drop table rent cascade constraint;
drop table return cascade constraint;
select * from customer;
select * from production;
select * from rent;
select * from return;

CREATE TABLE customer (
    id           VARCHAR2(30) NOT NULL,
    pw           VARCHAR2(30) NOT NULL,
    name         VARCHAR2(30) NOT NULL,
    phonenumber  VARCHAR2(30) NOT NULL,
    address      VARCHAR2(50) NOT NULL,
    account      VARCHAR2(30) NOT NULL,
    money        NUMBER(10)
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( id );


CREATE TABLE production (
    pnumber       VARCHAR2(30) NOT NULL,
    pname         VARCHAR2(30) NOT NULL,
    currentprice  NUMBER(20) NOT NULL,
    monthmoney    NUMBER(20) NOT NULL,
    pdetail       VARCHAR2(500),
    bigctg        VARCHAR2(30) NOT NULL,
    smallctg      VARCHAR2(30) NOT NULL,
    rcount        NUMBER(20),
    rstate        CHAR(1),
    customer_id   VARCHAR2(30) 
);

COMMENT ON COLUMN production.currentprice IS
    '각 물품에 대한 원가';

COMMENT ON COLUMN production.monthmoney IS
    '각 물품에 대한 한달 대여금액';

COMMENT ON COLUMN production.rcount IS
    '반납 완료에 대한 카운트';

ALTER TABLE production ADD CONSTRAINT production_pk PRIMARY KEY ( pnumber );

CREATE TABLE rent (
    rnumber             VARCHAR2(30) NOT NULL,
    deposit             NUMBER(10) NOT NULL,
    rmonth              NUMBER(3) NOT NULL,
    rmoney              NUMBER(10) NOT NULL,
    tpmoney             NUMBER(10) NOT NULL,
    rstart              DATE NOT NULL,
    rfinish             DATE NOT NULL,
    rback               VARCHAR2(30),  --반납신청여부
    latepayment         CHAR(1),
    epayback            NUMBER(10) NOT NULL,
    rbackdate           DATE,
    customer_id         VARCHAR2(30) NOT NULL,
    production_pnumber  NUMBER(20) NOT NULL
);

COMMENT ON COLUMN rent.deposit IS
    '연체 및 훼손 분실 방지를 위한 금액
원가*0.3';

COMMENT ON COLUMN rent.rmonth IS
    '물품대여시 대여할 기간
';

COMMENT ON COLUMN rent.rmoney IS
    '월금액*개월수';

COMMENT ON COLUMN rent.tpmoney IS
    '보증금+대여금액';

COMMENT ON COLUMN rent.rstart IS
    '대여시작일';

COMMENT ON COLUMN rent.rfinish IS
    '대여일+대여개월수';

COMMENT ON COLUMN rent.epayback IS
    '보증금 출력';

--CREATE UNIQUE INDEX rent__idx ON
--    rent (
--        production_pnumber
--    ASC );

ALTER TABLE rent ADD CONSTRAINT rent_pk PRIMARY KEY ( rnumber );

CREATE TABLE return (
    tnumber        VARCHAR2(30) NOT NULL,
    pstatescore         NUMBER(10),
    tdeposit       NUMBER(10),
    tmoney         NUMBER(10),
    tstate         CHAR(1),
    customer_id         VARCHAR2(30) NOT NULL,
    production_pnumber  VARCHAR2(30) NOT NULL,
    rent_rnumber        VARCHAR2(30) NOT NULL
); 
COMMENT ON COLUMN return.returndeposit IS
    '보증금~물품상태점수
~: %로 나눠줘야해서 1을 10%.......치환해서 계산하셈
2. 만약 (반납예정일-반납신청일 ==0  =>보증금 모두 반환';

COMMENT ON COLUMN return.returnmoney IS
    '1. 만약 (반납예정일-반납신청일) < 0 && 반납신청일 > 반납예정일+3개월 => 보증금 전액 몰수
2. 만약(반납예정일-반납신청일) > 0   => (반납예정일-반납신청일) * 0.5
';

--CREATE UNIQUE INDEX return__idx ON
--    return (
--        production_pnumber
--    ASC );
--
--CREATE UNIQUE INDEX return__idxv1 ON
--    return (
--        rent_rnumber
--    ASC );

ALTER TABLE return ADD CONSTRAINT return_pk PRIMARY KEY ( returnnumber );

ALTER TABLE production
    ADD CONSTRAINT production_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );

ALTER TABLE rent
    ADD CONSTRAINT rent_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );

ALTER TABLE rent
    ADD CONSTRAINT rent_production_fk FOREIGN KEY ( production_pnumber )
        REFERENCES production ( pnumber );

ALTER TABLE return
    ADD CONSTRAINT return_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );

ALTER TABLE return
    ADD CONSTRAINT return_production_fk FOREIGN KEY ( production_pnumber )
        REFERENCES production ( pnumber );

ALTER TABLE return
    ADD CONSTRAINT return_rent_fk FOREIGN KEY ( rent_rnumber )
        REFERENCES rent ( rnumber );


        
insert into customer values ('admin','1234','관리자','010-1234-5678','서울','123-12345-1234',0);
insert into customer values ('star1','12344','이순대','010-1235-5679','경기','124-12346-1235',0);
insert into customer values ('star2','12345','주니넬로','010-1236-5680','성남','125-12347-1236',860);
insert into customer values ('star3','12346','김엄마','010-1237-5681','광주','126-12348-1237',150000);
insert into customer values ('star4','12347','김막냉','010-1238-5682','순천','127-12349-1238',50000);
insert into customer values ('star5','12348','최형아','010-1239-5683','광주','128-12350-1239',10);
insert into customer values ('star6','12349','최성우','010-1240-5684','부산','129-12351-1240',36000);
insert into customer values ('star7','123410','별찍기','010-1241-5685','화천','130-12352-1241',79000);
insert into customer values ('star8','123411','김콩쥐','010-1242-5686','대구','131-12353-1242',15000);
insert into customer values ('star9','123412','최팥쥐','010-1243-5687','대전','132-12354-1243',20000);
insert into customer values ('star10','123413','이주모','010-1244-5688','인천','133-12355-1244',25000);

--===============================================================================================================


insert into production values('P001','치코 부스터',100000,25000,'3단계 높낮이 조절 기능으로 아기 성장단계에 맞추어 사용가능', '유아용품대여','식탁의자',17,'T','김엄마');
insert into production values('P002','개구리 점퍼루',100000,25000,'폴딩이 쉬워 공간활용에 편의,시트는 따로 분리하여 세탁', '유아용품대여','점퍼루',7,'T', '이순대');
insert into production values('P003','워크 어라운드',90000,25000,'흔들리지 않는 편안함', '유아용품대여','점퍼루',0,'F', NULL);
insert into production values('P004','스토케유모차',230000,58000,'핸들링과 지면 마찰을 최대한 줄여 이동성 제공', '유아용품대여','유모차',10,'T', '주니넬로');
insert into production values('P005','원숭이 점퍼루',95000,24000,'시트 쉽게 분리가능 및 세척에 용이', '유아용품대여','점퍼루',0,'F', NULL);
insert into production values('P006','트리플펀 아마존',130000,34000,'소리나는 완구는 물기제거 필수 및 시트패드는 중성제세로 물세탁', '유아용품대여','점퍼루',15,'F', '별찍기');
insert into production values('P007','원목침대',100000,25000,'흔들리지 않는 편안함과 떨어짐 방지', '유아용품대여','유아용 침대',23,'T', '김막냉');
insert into production values('P008','브라이텍스 카시트',180000,45000,'5점식 안전벨트, 어깨벨트 높이조절', '유아용품대여','카시트',12,'T', '최형아');
insert into production values('P009','트리플 펀 정글',80000,25000,'소리나는 완구는 물기제거 필수 및 시트패드는 중성제세로 물세탁', '점퍼루','유모차',0,'F', NULL);
insert into production values('P010','자전거 유아 안장',70000,20000,'아이의 체형을 생각한 디자인과 등받이와 발걸이로 안정감 제공', '기타유아 용품','유모차',0,'F',NULL);
insert into production values('P011','ABC스마트 스텝',100000,25000,'시트링 좌우 360도 회전가능', '유아용품대여','스텝',30,'T', '최성우');
insert into production values('P012','바운스 어바웃',100000,25000,'제자리에서 흔들거리며 넘어지지 않음, 아이의 텐션 업', '유아용품대여','스텝',0,'F',NULL);
insert into production values('P013','어라운드 위고',100000,25000,'20여가지의 다양한 사운드와 놀이기능', '유아용품대여','점퍼루',0,'F', NULL);
insert into production values('P014','트리플 펀 아마존',130000,30000,'소리나는 완구는 물기제거 필수 및 시트패드는 중성제세로 물세탁', '유아용품대여','점퍼루',0,'F',NULL);
insert into production values('P015','리모컨 전동침대',80000,20000,'전자석 원리로 소음없음', '유아용품대여','유아용 침대',24,'T', '김콩쥐');
insert into production values('P016','브라이텍스 파크웨이',140000,35000,'측면충돌시 충격 흡수를 위한 시스템', '유아용품대여','카시트',0,'F', NULL);
insert into production values('P017','치코보행기',100000,25000,'아이의 성장 속도에 맞게 3단계 높이 조절가능', '유아용품대여','보행기 ',28,'F', '최팥쥐');
insert into production values('P018','피셔프라이스부스터',86000,20000,'다채로운색감과 다양한 장난감으로 시선 강탈', '유아용품대여','식탁의자',0,'F', NULL);
insert into production values('P019','비원신생아카시트',145000,30000,'바운서로 보호자의 휴식시간 제공,전용침대 및 캐리어로 사용가능', '유아용품대여','카시트',0,'F',NULL);
insert into production values('P020','입느플로 카시트',115000,30000,'안락감을 주는 색감과 꿀잠 유도', '유아용품대여','카시트',0,'F', NULL);
insert into production values('P021','치코폴리식탁의자',130000,30000,'원터치 와이드 식판,7단계 높이조절', '유아용품대여','식타의자',4,'T', '별찍기');
insert into production values('P022','주마 식탁의자',155000,40000,'손쉽게 탈/부착 가능 및 손세탁이 가능한 2중 패브릭 시트', '유아용품대여','식탁의자',17,'F', '주니넬로');
insert into production values('P023','보미 식탁의자',80000,20000,'푹신푹신한 의자와 플라스틱 및 원터치 브레이크 내장 바퀴 6단계 제공', '유아용품대여','식탁의자',0,'F', NULL);
insert into production values('P024','범보 의자',83000,20000,'힘이 없는 아기가 바로 앉을 수 있도록 제조', '유아용품대여','식탁의자',0,'F', NULL);
insert into production values('P025','치코 부스터',100000,25000,'3단계 높낮이 조절 기능으로 아기 성장단계에 맞추어 사용가능', '유아용품대여','유모차',0,'F', NULL);
insert into production values('P026','개구리 점퍼루',100000,25000,'폴딩이 쉬워 공간활용에 편의,시트는 따로 분리하여 세탁', '유아용품대여','소서',8,'T', '최팥쥐');
insert into production values('P027','워크어라운드',90000,25000,'흔들리지 않는 편안함', '유아용품대여','유모차',0,'F', NULL);
insert into production values('P028','치코 부스터',100000,25000,'3단계 높낮이 조절 기능으로 아기 성장단계에 맞추어 사용가능', '유아용품대여','유모차',0,'F', NULL);
insert into production values('P029','스토케 유모차',230000,58000,'핸들링과 지면 마찰을 최대한 줄여 이동성 제공', '유아용품대여','유모차',0,'F', NULL);
insert into production values('P030','치코보행기',100000,25000,'아이의 성장 속도에 맞게 3단계 높이 조절가능', '유아용품대여','보행기',7,'T', '이주모');

--====================================================================================================================



insert into rent values('R001',30000,1,25000,55000,'2020-01-20','2020-02-20','반납신청','T',30000,'2020-02-24','김엄마',001);
insert into rent values('R002',30000,3,25000,105000,'2020-02-24','2020-05-24','반납완료','F',30000,'2020-04-24','이순대',002);
insert into rent values('R003',69000,2,58000,185000,'2020-03-24','2020-05-24','반납신청','F',69000,'2020-05-24','주니넬로',004);
insert into rent values('R004',39000,1,34000,73000,'2020-04-24','2020-05-24','반납신청','F',39000,'2020-05-24','별찍기',006);
insert into rent values('R005',30000,1,25000,55000,'2020-05-24','2020-06-24','반납완료','F',30000,'2020-06-24','김막냉',007);
insert into rent values('R006',54000,3,45000,189000,'2020-06-24','2020-09-24','반납완료','F',54000,'2020-09-24','최형아',008);
insert into rent values('R007',30000,3,25000,105000,'2020-07-24','2020-10-24','반납신청','T',30000,'2021-01-01','최성우',011);
insert into rent values('R008',24000,2,20000,64000,'2021-04-24','2021-06-24',NULL,NULL,24000,NULL,'김콩쥐',015);
insert into rent values('R009',30000,2,25000,80000,'2021-04-24','2021-06-24',NULL,NULL,30000,NULL,'최팥쥐',017);
insert into rent values('R010',39000,1,30000,69000,'2021-04-24','2021-05-24',NULL,NULL,39000,NULL,'별찍기',021);
insert into rent values('R011',46500,1,40000,86500,'2021-04-24','2021-05-24',NULL,NULL,46500,NULL,'주니넬로',022);
insert into rent values('R012',30000,2,25000,80000,'2021-04-24','2021-06-24',NULL,NULL,30000,NULL,'최팥쥐',026);
insert into rent values('R013',30000,1,25000,55000,'2021-04-24','2021-05-24',NULL,NULL,30000,NULL,'이주모',030);

--===================================================================================================================



insert into return values('T001',10,0,0,'T','김엄마','P001','R001');
insert into return values('T002',4,12000,25000,'T','이순대','P002','R002');
insert into return values('T003',1,6900,0,'T','주니넬로','P004','R003'); 
insert into return values('T004',10,0,0,'T','별찍기','P006','R004');
insert into return values('T005',10,0,0,'T','김막냉','P007','R005');
insert into return values('T006',10,0,0,'T','최형아','P008','R006');
insert into return values('T007',1,0,0,'T','최성우','P011','R007');


select pname "물품명",pnumber "물품번호",bigctg "대분류",smallctg "소분류",currentprice "가격",rstate "대여상태(T/F)" from production;
delete from production where pnumber='P029';
select * from production;
select * from rent;
Select customer_id, production_pnumber, rstart, rfinish, latepayment, tpmoney,epayback from rent;

Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where rback ='반납신청' or rback ='반납완료';
select * from return;
Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where latepayment!='null';
--select P.currentprice from production P, rent R where R.TO_DATE(rfinish) - R.TO_DATE(backdate)>=15 and P.customer_id = R.customer_id;
select rnumber from rent where to_date(rfinish) - to_date(rbackdate) >=15;
Select customer_id,production_pnumber,rmoney,rstart,rfinish,epayback,rback from rent;








--latepayment = char여서 null을 우리가 직접 입력해줬기 때문에 'null'써줌 

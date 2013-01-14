register lib/*.jar; 

register dist/lib/commoncrawl-examples-1.0.1.jar;

register trunk/myudfs.jar;

a = LOAD '/data/public/common-crawl/award/testset/*.arc.gz' USING org.commoncrawl.pig.ArcLoader() as (date, length, type, statuscode, ipaddress, url, html);
b = LOAD 'companies' USING PigStorage(':') AS (rank:int, name:chararray);

X = FOREACH a GENERATE date, ipaddress, html;
Z = FILTER X BY html IS NOT NULL;
P = FOREACH Z GENERATE myudfs.companies(html) AS present;
P2 = FILTER P BY present IS NOT NULL;
P3 = FOREACH P2 GENERATE FLATTEN(present) AS company;
P4 = GROUP P3 BY company;
P5 = FOREACH P4 GENERATE group, COUNT(P3) as counting;

P6 = JOIN b BY name, P5 BY group;
P7 = FOREACH P6 GENERATE rank, name, counting;
P8 = ORDER P7 BY rank;

STORE P8 INTO 'resultSARATestSet';

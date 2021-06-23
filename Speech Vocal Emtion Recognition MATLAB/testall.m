x=input('请选择分析语音心情的音频文件:','s');
out1=tempread('zik','pbf',[0,1,2]);
out2=tempread('zj','pbf',[0,1,2]);
out3=tempread('wwt','pbf',[0,1,2]);

tt=paracal(x)';

s1=elsort15(tt,out1,2);
s2=elsort15(tt,out2,2);
s3=elsort15(tt,out3,2);

s=s1+s2+s3;
[k,r]=max(s);

if r==1;
    disp('判断结果：平静');
end
if r==2
     disp('判断结果：悲伤');
end
if r==3
     disp('判断结果：愤怒');
end
scoreall=sum(s);

        disp('分数：');
        disp(['平静:',num2str(100*s(1)/scoreall)]);
        disp(['悲伤:',num2str(100*s(2)/scoreall)]);
        disp(['愤怒:',num2str(100*s(3)/scoreall)]);
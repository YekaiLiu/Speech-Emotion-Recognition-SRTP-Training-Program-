x=input('��ѡ����������������Ƶ�ļ�:','s');
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
    disp('�жϽ����ƽ��');
end
if r==2
     disp('�жϽ��������');
end
if r==3
     disp('�жϽ������ŭ');
end
scoreall=sum(s);

        disp('������');
        disp(['ƽ��:',num2str(100*s(1)/scoreall)]);
        disp(['����:',num2str(100*s(2)/scoreall)]);
        disp(['��ŭ:',num2str(100*s(3)/scoreall)]);
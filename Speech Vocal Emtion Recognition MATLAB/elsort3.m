function [r,s]=elsort3(x,out,k)
% path='d:\xlj\zik\';
%x=input('文件','s');
tt=paracal(x)';
% for m=1:length(no)
%     eval([mch(m),'=out.'mch(m),';'])
%     eval(['size',mch(m),'=size(',mch(m),');'])
%     
    
p=out.p;
b=out.b;
f=out.f;

mp=mean(p');
mb=mean(b');
mf=mean(f');

vp=sqrt(var(p'));
vb=sqrt(var(b'));
vf=sqrt(var(f'));

np=((mp-tt)./vp).^2;
nb=((mb-tt)./vb).^2;
nf=((mf-tt)./vf).^2;

mup=1;
mub=1;
mug=1;

for i=1:k
    mup=mup*vp(k);
    mub=mub*vb(k);
    muf=mup*vf(k);
end
scorep=exp(-sum(np(1:k))/2)/(2*pi*mup);
scoreb=exp(-sum(nb(1:k))/2)/(2*pi*mub);
scoref=exp(-sum(nf(1:k))/2)/(2*pi*muf);

scoreall=scorep+scoreb+scoref;

if scorep==max([scorep,scoreb,scoref])
    r=0;
    disp('判断结果：平静');
end
if scoreb==max([scorep,scoreb,scoref])
    r=1;
     disp('判断结果：悲伤');
end
if scoref==max([scorep,scoreb,scoref])
    r=2;
     disp('判断结果：愤怒');
end


s=[100*scorep/scoreall,100*scoreb/scoreall,100*scoref/scoreall];
        disp('分数：');
        disp(['平静:',num2str(100*scorep/scoreall)]);
        disp(['悲伤:',num2str(100*scoreb/scoreall)]);
        disp(['愤怒:',num2str(100*scoref/scoreall)]);
       
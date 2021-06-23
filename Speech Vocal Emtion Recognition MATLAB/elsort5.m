function [r,s]=elsort5(x,out,k)
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
g=out.g;
j=out.j;

mp=mean(p');
mb=mean(b');
mf=mean(f');
mj=mean(j');
mg=mean(g');
vp=sqrt(var(p'));
vb=sqrt(var(b'));
vf=sqrt(var(f'));
vj=sqrt(var(g'));
vg=sqrt(var(j'));
np=((mp-tt)./vp).^2;
nb=((mb-tt)./vb).^2;
nf=((mf-tt)./vf).^2;
nj=((mj-tt)./vj).^2;
ng=((mg-tt)./vg).^2;

mup=1;
mub=1;
mug=1;
muj=1;
mug=1;
for i=1:k
    mup=mup*vp(k);
    mub=mub*vb(k);
    muf=mup*vf(k);
    mug=mup*vg(k);
    muj=mup*vj(k);
end
scorep=exp(-sum(np(1:k))/2)/(2*pi*mup);
scoreb=exp(-sum(nb(1:k))/2)/(2*pi*mub);
scoref=exp(-sum(nf(1:k))/2)/(2*pi*muf);
scorej=exp(-sum(nj(1:k))/2)/(2*pi*muj);
scoreg=exp(-sum(ng(1:k))/2)/(2*pi*mug);
scoreall=scorep+scoreb+scoref+scorej+scoreg;

if scorep==max([scorep,scoreb,scoref,scorej,scoreg])
    r=0;
    disp('判断结果：平静');
end
if scoreb==max([scorep,scoreb,scoref,scorej,scoreg])
    r=1;
     disp('判断结果：悲伤');
end
if scoref==max([scorep,scoreb,scoref,scorej,scoreg])
    r=2;
     disp('判断结果：愤怒');
end
if scoreg==max([scorep,scoreb,scoref,scorej,scoreg])
    r=3;
    disp('判断结果：高兴');
end 
if scorej==max([scorep,scoreb,scoref,scorej,scoreg])
    r=4;
    disp('判断结果：惊讶');
end 

s=[100*scorep/scoreall,100*scoreb/scoreall,100*scoref/scoreall,100*scoreg/scoreall,100*scorej/scoreall];
        disp('分数：');
        disp(['平静:',num2str(100*scorep/scoreall)]);
        disp(['悲伤:',num2str(100*scoreb/scoreall)]);
        disp(['愤怒:',num2str(100*scoref/scoreall)]);
        disp(['惊讶:',num2str(100*scorej/scoreall)]);
        disp(['高兴:',num2str(100*scoreg/scoreall)]);
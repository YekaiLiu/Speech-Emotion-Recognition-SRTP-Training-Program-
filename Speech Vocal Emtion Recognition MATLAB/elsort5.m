function [r,s]=elsort5(x,out,k)
% path='d:\xlj\zik\';
%x=input('�ļ�','s');
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
    disp('�жϽ����ƽ��');
end
if scoreb==max([scorep,scoreb,scoref,scorej,scoreg])
    r=1;
     disp('�жϽ��������');
end
if scoref==max([scorep,scoreb,scoref,scorej,scoreg])
    r=2;
     disp('�жϽ������ŭ');
end
if scoreg==max([scorep,scoreb,scoref,scorej,scoreg])
    r=3;
    disp('�жϽ��������');
end 
if scorej==max([scorep,scoreb,scoref,scorej,scoreg])
    r=4;
    disp('�жϽ��������');
end 

s=[100*scorep/scoreall,100*scoreb/scoreall,100*scoref/scoreall,100*scoreg/scoreall,100*scorej/scoreall];
        disp('������');
        disp(['ƽ��:',num2str(100*scorep/scoreall)]);
        disp(['����:',num2str(100*scoreb/scoreall)]);
        disp(['��ŭ:',num2str(100*scoref/scoreall)]);
        disp(['����:',num2str(100*scorej/scoreall)]);
        disp(['����:',num2str(100*scoreg/scoreall)]);
function s=elsort15(tt,out,k)

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

s=[scorep,scoreb,scoref];
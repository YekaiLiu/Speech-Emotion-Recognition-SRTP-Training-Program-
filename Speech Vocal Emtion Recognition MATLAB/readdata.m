function result=readdata(str,N)
[Y,fs,nbits]=wavread(str);
sd=size(Y);
ys=Y(:,sd(2));
m=1;
k=length(ys);
while ys(m)<0.02;
    m=m+1;
end

while ys(k)<0.02;
    k=k-1;
end
y=ys(m:k);
w=y.*y;
n=length(y);

for i=1:n-N
    %zr(i)=ZRate(y(i:i+N-1));
    p(i)=sum(w(i:i+N-1));
end

sig=sign(p-sum(p)/length(p)/3);


T=jiyin(y,512,sig,50);
f=fs./T;
result.p=p;
result.f=f;
result.y=y;
result.sig=sig;
result.fs=fs;
function out1=pu4(str)
[d,FS,NBITS]= wavread(str);
sd=size(d);
y1=d(:,sd(2));
p=1;
a=fix(length(y1)/240)-4;
s=ones(1,a+1);
s2=ones(1,a+1);
s1=ones(1,a+1);
e=ones(1,a+1);
h=ones(1,a+1);
for i=1:240:a*240+1
%i=33*240+1;
y=y1(i:i+639);
f=abs(fft(y));
y=y.*hamming(640);
g=log(abs(fft(y)));
g2=ifft(g);
t1=g2;
t1(40:600)=0;
e1=abs(exp(fft(t1)));
[m,n]=max(e1(5:160));   
[m2,n2]=max(f(5:160));
s(p)=n+4;
s2(p)=n2+4;
e(p)=sum(abs(sgn2(y(2:640))-sgn2(y(1:639))))/2/639;
h(p)=sum(abs(y));
p=p+1;
end;
for p=1:a+1
      if e(p)>max(e)*0.4& h(p)<max(h)*0.3
        s(p)=0    ;
        s1(p)=0;
        s2(p)=0;
     end;
     if p<a+1
     if e(p)==0&abs(h(p)-h(p+1))/max(h)<0.05
         s(p)=0    ;
        s1(p)=0;
        s2(p)=0;
    end;
    end;
      if h(p)/max(h)<0.30
%         s(p)=0   ; 
%         s1(p)=0;
%         s2(p)=0;
      end;
      if g(p)>50
      %    s(p)=0;
      %    s1(p)=0;
      %    s2(p)=0;
      end;
  end;
sum(s1);
  out1=sum(s)/sum(s1);
  %out2(2)=sum(s2)/sum(s1);
  x=(1:240:a*240+1)/16000;
  

% plot(x,s,'b.')
%   plot(x,s,'r',x,s2,'b')
%plot(1:160,e1(1:160).*(max(abs(f))/max(e1)),'r',1:160,abs(f(1:160)),'b')
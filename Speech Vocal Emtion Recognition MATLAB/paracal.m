function y=paracal(x)
try
    s=load(x);
    ru=s.ru;
    disp([x,':old']);
catch
    ru=readdata(x,512);
    %save(x,'ru');

    disp([x,':new']);
end
[xx,xy]=jpa(ru);
yy=pu4(x);
y=[xx;yy;xy];
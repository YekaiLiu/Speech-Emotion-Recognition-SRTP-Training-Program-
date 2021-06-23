function f=amdf(x,n)
ymax=0;
f=16000;
xmax=max(abs(x));
for i=1:length(x)
   if x(i)>xmax*0.68;
        x(i)=x(i)-xmax*0.68;
    elseif x(i)<xmax*(-0.68);
        x(i)=x(i)+xmax*0.68;
    else
        x(i)=0;
    end
end
for i=40:400
    y(i)=sum(x(1:n).*x(i+1:i+n));
    %y(i)=sum(abs(x(1:n)-x(i+1:i+n)));
    if y(i)>ymax
        ymax=y(i);
        f=i;
    end
end
if (i==400)|(i==40)
    i=0;
end
    
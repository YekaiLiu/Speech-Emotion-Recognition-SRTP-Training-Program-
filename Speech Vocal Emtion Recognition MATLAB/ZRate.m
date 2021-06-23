function y=ZRate(x);
y=0;
for i=1:length(x)-1;
    if (x(i)*x(i+1)<0)
        y=y+1;
    elseif x(i)==0
        y=y+1;
    end
end
if x(length(x))==0
    y=y+1;
end
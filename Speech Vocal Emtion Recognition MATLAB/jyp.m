function y=jyp(x)
num=0;
for i=1:length(x)
    if x(i)>340 | x(i) <80
        y(i)=1;
    else y(i)=x(i);
    end
end


function [y,yvar]=jpa(o)
% s=load('D:\xlj\zik\j31');
% o=s.ru;
x=jyp(o.f);
p=o.p;
n=0;
for i=1:length(x)
    if x(i)~=1
        try
            xp=[xp,x(i)];
        catch
            xp=x(i);
        end
    end
end
xpt=pa(xp);
y=mean(xp);
yvar=var(diff(p)/mean(p));
%mean(diff(p)/mean(p));
%yvar=var(p/mean(p))*(length(p)-1)/length(p);
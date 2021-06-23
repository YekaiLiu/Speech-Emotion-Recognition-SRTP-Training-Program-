function y=jiyin(x,n,sig,step)
for i=1:step:length(x)-n-800
        q=amdf(x(i:i+n+800),800);
        yo(round(i/step)+2)=q;
        if (abs(yo(round(i/step)+2)-yo(round(i/step)+1))>10)|sig(i)<1
            y(round(i/step)+2)=16000;
            y(round(i/step)+1)=16000;
        else y(round(i/step)+2)=yo(round(i/step)+2);
        end
end
        
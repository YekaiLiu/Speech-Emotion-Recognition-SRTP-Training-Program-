for i=1:60
p(1,i)=out.p(1,i);j(1,i)=out.j(1,i);b(1,i)=out.b(1,i);
p(2,i)=out.p(2,i);j(2,i)=out.j(2,i);b(2,i)=out.b(2,i);
end
for i=1:60
     P(1,i)=p(1,i);P(1,i+60)=b(1,i);
%    P(1,i)=j(1,i);P(1,i+60)=b(1,i);
%    P(1,i)=p(1,i);P(1,i+60)=j(1,i);
     P(2,i)=p(2,i);P(2,i+60)=b(2,i);
%    P(2,i)=p(2,i);P(2,i+60)=j(2,i);
%    P(2,i)=j(2,i);P(2,i+60)=b(2,i);
    T(1,i)=0;T(1,i+60)=1;
    T(2,i)=0;T(2,i+60)=1;
end
net=newp([100,260;10,30],2);
figure;
watchon;
cla;
plotpv(P,T);
linehandle=plotpc(net.IW{1},net.b{1});
E=1;
net=init(net);
linehandle=plotpc(net.IW{1},net.b{1});
while(sse(E))
    [net,Y,E]=adapt(net,P,T);
    linehandle=plotpc(net.IW{1},net.b{1},linehandle);
    drawnow;
end;
watchoff;

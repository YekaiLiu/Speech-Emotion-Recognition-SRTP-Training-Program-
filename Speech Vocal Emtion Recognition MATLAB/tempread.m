function out=tempread(user,mch,no)
%function out=tempread(user)
path=['D:\xlj\',user,'\'];
tempname=['temp',user];
s=load([path,tempname]);
temp=s.temp;
p=size(temp);
r=p(1);
c=p(2);
for i=1:c
    for m=1:length(no)
        if temp(1,i)==no(m)
            try
                eval(['out.',mch(m),'=[out.',mch(m),',temp(2:r,i)];'])
            catch
                eval(['out.',mch(m),'=temp(2:r,i);']);
            end
        end
    end    
%     if temp(1,i)==0
%         out.p=[out.p,temp(2:3,i)];
%     elseif temp(1,i)==1
%         out.b=[out.b,temp(2:3,i)];
%     elseif temp(1,i)==2
%         out.f=[out.f,temp(2:3,i)];
%     end
end

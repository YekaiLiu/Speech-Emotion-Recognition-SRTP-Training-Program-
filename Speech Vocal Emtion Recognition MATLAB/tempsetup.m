disp('请输入用户名:');
user=input('','s');
path=['D:\xlj\',user,'\'];
tempname=['temp',user];
mch='pbfgj';
no=0:length(mch)-1;

[str,ele]=scanfolder(path,mch,no);
temptrain(str,tempname,path,ele,0);
out=tempread(user,mch,no);

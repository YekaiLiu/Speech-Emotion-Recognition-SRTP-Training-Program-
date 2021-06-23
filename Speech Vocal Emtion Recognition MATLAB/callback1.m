user=get(gcbo,'string'); 
%ft2death(h_edit1,h_text1,user,str1);

set(h_edit1,'style','text');
set(h_edit1,'string',user);
set(h_text1,'string',str1);
mch='pbfgj';
no=[0,1,2,3,4];

try 
    %out=tempread(user,mch,no);
    
    h_text2=uicontrol(h_fig,'style','text','unit','normalized',...
        'position',[0.1,0.6,0.25,0.05],'horizontal','left',...
        'string','请输入测试文件名:','ForegroundColor',defcolor);
    
    h_edit2=uicontrol(h_fig,'style','edit','unit','normalized',...
        'position',[0.1,0.50,0.25,0.05],'horizontal','left',...
        'ForegroundColor',defcolor,'callback','callback2');
    
    h_push3=uicontrol(h_fig,'style','push','unit','normalized',...
        'position',[0.37,0.5,0.10,0.05],'horizontal','left',...
        'string','浏览','ForegroundColor',defcolor,'callback','printru2');
    

    h_push1=uicontrol(h_fig,'style','push','unit','normalized',...
        'position',[0.8,0.3,0.18,0.05],'horizontal','left',...
        'string','注销','ForegroundColor',defcolor,'callback','guifinal');
 
    drawnow;
catch
    nouser;
end
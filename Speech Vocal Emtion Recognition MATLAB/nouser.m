set(h_text3,'string','此用户尚未建立');

set(h_text4,'string','单击确定重新登陆');

set(h_text5,'string','');

set(h_text6,'string','');

set(h_text7,'string','');


h_push1=uicontrol(h_fig,'style','push','unit','normalized',...
    'position',[0.8,0.3,0.18,0.05],'horizontal','left',...
    'string','确定','ForegroundColor',defcolor,'callback','guifinal');

drawnow;

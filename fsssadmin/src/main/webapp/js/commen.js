var showurl;
var showcol;
function loadGrid()  
{  
//加载数据  
$('#drug_dg').datagrid({
        width: 'auto',  
        height:300,     
        striped: true,
        singleSelect : true,
        url:showurl,  
        loadMsg:'数据加载中请稍后……',  
        pagination: true,
        rownumbers: true,
        columns:showcol
    });  
}  
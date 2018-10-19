<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['bar']});
google.charts.load('current', {'packages':['corechart']});


// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart1);
google.charts.setOnLoadCallback(drawChart2);
google.charts.setOnLoadCallback(drawChart3);



// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart1() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', '연령대');
        data.addColumn('number', '지원자수');
        data.addRows([
          ['20대 초,중반', 57],
          ['20대 후반', 102],
          ['30대', 38],
          ['40대', 13],
        ]);

        // Set chart options
        var options = {'title':'Win-Win 연령대별 입사 지원자 수',
                       'width':400,
                       'height':300,
                       'bars':'vertical'};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.charts.Bar(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      
function drawChart2() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', '학력');
    data.addColumn('number', '지원자수');
    data.addRows([
      ['고등학교 졸업', 57],
      ['대학 2년제', 102],
      ['대학 4년제', 38],
      ['석/박사', 13],
    ]);

    // Set chart options
    var options = {'title':'학력별 지원자 현황',
                   'width':400,
                   'height':300};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('another_chart_div'));
    chart.draw(data, options);
  }
function drawChart3() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', '분기별');
    data.addColumn('number', '지원자수');
    data.addRows([
      ['2016년 상반기', 780],
      ['2016년 하반기', 997],
      ['2017년 상반기', 860],
      ['2017년 하반기', 1307],
      ['2018년 상반기', 923],
      ['2018년 하반기', 1582],
    ]);

    // Set chart options
    var options = {title:'분기별 지원자 현황',
                   width:400,
                   height:300,
                   	hAxis:{title:'분기'},
    				vAxis:{minValue:0, maxValue:1800}
    				};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.AreaChart(document.getElementById('theother_chart_div'));
    chart.draw(data, options);
  }
</script>
<style type="text/css">
.tableBox{
	padding : 6px;
}
.header{
	background-color: lightgray;
	font-weight: bold;
	text-align: center;
	
}
tr,td{
	text-align: center;
}
</style>

</head>
<body>
<h1>메인페이지</h1>
<hr>
<table>
	<tr>   <!--Div that will hold the pie chart-->
    	<td><div id="chart_div"></div></td>
    	<td><div id="another_chart_div"></div></td>
   		<td><div id="theother_chart_div"></div></td>
	</tr>
	<tr>
		<td class="tableBox">
			<table class="table table-bordered">
				<tr class="header">
					<td>
					연령대
					</td>
					<td>
					입사지원자 수
					</td>
				</tr>
				<tr>
					<td>
					20대 초,중반
					</td>
					<td>
					57
					</td>
				</tr>
				<tr>
					<td>
					20대 후반
					</td>
					<td>
					102
					</td>
				</tr>
				<tr>
					<td>
					30대
					</td>
					<td>
					38
					</td>
				</tr>
				<tr>
					<td>
					40대
					</td>
					<td>
					13
					</td>
				</tr>
			</table>
		</td>
		<td class="tableBox">
			<table class="table table-bordered">
				<tr class="header">
					<td>
					학력별
					</td>
					<td>
					입사지원자 수
					</td>
				</tr>
				<tr>
					<td>
					고등학교 졸업
					</td>
					<td>
					57
					</td>
				</tr>
				<tr>
					<td>
					대학교 2년제
					</td>
					<td>
					102
					</td>
				</tr>
				<tr>
					<td>
					대학교 4년제
					</td>
					<td>
					38
					</td>
				</tr>
				<tr>
					<td>
					석/박사
					</td>
					<td>
					13
					</td>
				</tr>
			</table>
		</td>
		<td class="tableBox">
			<table class="table table-bordered">
				<tr class="header">
					<td>
					분기별
					</td>
					<td>
					입사지원자 수
					</td>
				</tr>
				<tr>
					<td>
					2016년 상반기
					</td>
					<td>
					780
					</td>
				</tr>
				<tr>
					<td>
					2016년 하반기
					</td>
					<td>
					 997
					</td>
				</tr>
				<tr>
					<td>
					2017년 상반기
					</td>
					<td>
					860
					</td>
				</tr>
				<tr>
					<td>
					2017년 하반기
					</td>
					<td>
					1307
					</td>
				</tr>
				<tr>
					<td>
					2018년 상반기
					</td>
					<td>
					923
					</td>
				</tr>
				<tr>
					<td>
					2018년 하반기
					</td>
					<td>
					1582
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>    
    
<br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>
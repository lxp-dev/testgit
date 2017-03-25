/*
Powered by ly200.com		http://www.ly200.com
广州联雅网络科技有限公司		020-83226791
*/

var stores_obj={
	stores_init:function(){
		$('a[name=tellist]').live('click',function(){
			system_obj.div_mask();
			left=($(document).width()-$('#tel_box').width())/2;
			top=$(window).scrollTop()+15;
			$('#tel_list').html('');
			if($(this).parent().parent().parent().find('.tel_list').size()){
				$('#tel_list').html($(this).parent().parent().parent().find('.tel_list').html());
			}
			$('#tel_box').css({'left':left+'px','top':top+'px'}).show();
		});
		$('.cancel_btn').click(function(){
			$('#tel_box').hide();	
			system_obj.div_mask(1);
		});
		
		$('#footer select').change(function(){
			window.location.href=window.PG.url_pre_module+'?GId='+$(this).val();	
		});
		if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(function(pos){
			}, function(error){
				switch(error.code){
					case error.TIMEOUT:
						error_msg='无法获取地理位置！';
						break;
					case error.PERMISSION_DENIED:
						error_msg='您未允许浏览器提供地理位置服务，无法导航！';
						break;
					case error.POSITION_UNAVAILABLE:
						error_msg='浏览器获取地理位置服务不可用！';
						break;
					default:
						error_msg='未知错误！';
						break;
				}
				$('#stores_cont').html($('#stores_ext').html());
				$('#address_cont').html(error_msg);
			}, {enableHighAccuracy:true, maximumAge:1000, timeout:5000});
		}else{
			$('#stores_cont').html($('#stores_ext').html());
			$('#address_cont').html('浏览器不支持导航');	
		}
		
		
		var getRad=function(d){
			return d*(Math.PI)/180.0;
		}
		
		var getDistance=function(lat1, lng1, lat2, lng2){
			lat1=lat1*1;
			lng1=lng1*1;
			lat2=lat2*1;
			lng2=lng2*1;
			var f=getRad((lat1+lat2)/2);
			var g=getRad((lat1-lat2)/2);
			var l=getRad((lng1-lng2)/2);
			
			var sf=Math.sin(f);
			var sg=Math.sin(g);
			var sl=Math.sin(l);
			
			var s, c, w, r, d, h1, h2;
			var fl=1/298.257;
			
			sg=sg*sg;
			sl=sl*sl;
			sf=sf*sf;
			
			s=sg*(1-sl)+(1-sf)*sl;
			c=(1-sg)*(1-sl)+sf*sl;
			
			w=Math.atan(Math.sqrt(s/c));
			r=Math.sqrt(s*c)/w;
			d=2*w*6378137.0;
			h1=(3*r-1)/2/c;
			h2=(3*r+1)/2/s;
			
			return d*(1+fl*(h1*sf*(1-sg)-h2*(1-sf)*sg));
		};
		
		var getFriendDistance=function(lat1, lng1, lat2, lng2){
			var dis=0;
			if(arguments.length==1){
				dis=lat1;
			}else{
				dis=getDistance(lat1, lng1, lat2, lng2);
			}
			if(dis<10000){
				return '约'+(dis>>0)+'m';
			}else{
				return '约'+((dis/1000)>>0)+'km';
			}
		};
		
    	//计算距离，显示最近的
		var showNearest=function(lat1, lng1){
			var stores_ary=new Array();
			var nearest_index=-1, nearest_dis=-1;
			$('#stores_ext .store').each(function(index){
				var lat=$(this).attr('lat'), lng=$(this).attr('lng');
				if(lat && lng){
					var dis=getDistance(lat, lng, lat1, lng1);
					var dis_f=getFriendDistance(dis);
					if(nearest_dis<0 || dis<nearest_dis){
						nearest_dis=dis;
						nearest_index=index;
					}
					$('.dis', $(this)).html(dis_f);
					var ary_count=0;
					for(j in stores_ary){
						j==parseInt(dis)+ary_count && ary_count++;
					}
					stores_ary[parseInt(dis)+ary_count]=$(this).html();
				}
			});
			
			/*if(nearest_index>-1){//把最近得显示在前面
				$($('#stores .store').get(nearest_index)).addClass('nearest').prependTo($('#stores'));
			}*/
			var j=0;
			$('#stores_cont').html('');
			for(i in stores_ary){
				var _class=j==0?'store nearest':'store';
				$('#stores_cont').append('<div class="'+_class+'">'+stores_ary[i]+'</div>');
				j++;
			}
			
		};
		
		renderReverse=function(response){
			var addr=response.result.formatted_address;
			if(addr){
				$('#address_cont').html(addr);
			}
		}
		
		var geolocation=new BMap.Geolocation();
		geolocation.getCurrentPosition(function(pos){
			showNearest(pos.point.lat, pos.point.lng);
			var url="http://api.map.baidu.com/geocoder/v2/?ak="+baidu_map_ak+"&callback=renderReverse&location="+pos.point.lat+","+pos.point.lng+"&output=json&pois=0";
			var script=document.createElement('script');
			script.type='text/javascript';
			script.src=url;
			document.body.appendChild(script);
		});
		
		/*if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(function(pos){
				showNearest(pos['coords']['latitude'], pos['coords']['longitude']);
			}, function(error){
				switch(error.code){
					case error.TIMEOUT:
						global_obj.win_alert('浏览器获取地理位置超时！');
						break;
					case error.PERMISSION_DENIED:
						global_obj.win_alert('您未允许浏览器提供地理位置服务，无法导航！');
						break;
					case error.POSITION_UNAVAILABLE:
						global_obj.win_alert('浏览器获取地理位置服务不可用！');
						break;
					default:
						break;
				}
			}, {enableHighAccuracy:true, maximumAge:1000, timeout:5000});
		}*/
	}
}
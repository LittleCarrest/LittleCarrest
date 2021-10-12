/**
 * 
 */

let createPopup = (popupInfo)=>{	//매개변수 popupInfo는 객체 형태일 것
	let left = (window.innerWidth/2)-popupInfo.width/2;
	let top = (window.innerHeight/2)-popupInfo.height/2;
	
	let popup = open(popupInfo.url,popupInfo.name
					,`width=${popupInfo.width},height=${popupInfo.height},left = ${left},top=${top}`);
}


let createQueryString = params => {
	let arr = [];
	for(key in params){
		arr.push(key + '=' + params[key]);
	}
	
	return arr.join('&');
}
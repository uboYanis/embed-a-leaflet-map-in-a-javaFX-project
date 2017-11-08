//	js and leaflet stuff

var map=L.map('map',{
	center: [5,28],
	zoom:3,
	minZoom:2,
	maxZoom:18
});

L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	attribution: '&copy; <a href=”http://osm.org/copyright”>OpenStreetMap</a> contributors'
}).addTo(map);

var myIcon = L.icon({
	iconUrl: 'img/placeholder.png'
});

var arr= [data2];

function add(param){
	arr.push(param);
}

function drawFeature(feature,layer){
	//layer.bindPopup("<p>"+feature.properties.color+"</p>"); // pour google
	//layer.setIcon(myIcon)

};
document.run = function(){
	for (i = 0; i < arr.length; i++) { 
		L.geoJSON(arr[i], {
			onEachFeature : drawFeature
		}).addTo(map); 
	}
};




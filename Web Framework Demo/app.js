var fs=require('fs');
var express = require('express');
var path = require('path');
var bodyParser=require('body-parser');
var MongoClient = require('mongodb').MongoClient;
var app = express();

var http = require('http').Server(app);

app.use(bodyParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.static(__dirname));


// Setup API by ntwitter
var twitter = require('twitter');

var twit = new twitter({
  consumer_key: 'TVnxUPDKZNRn8l8DXgblRSY9e',
  consumer_secret: '6pr84NIpiSsn2ICsn6oyuZ0mHXQ53tLKKQnjjQYvpIoBKOwrYg',
  access_token_key: '2743221905-DkZbWgQOuxPjeeG4cv1DiVExeJiwzJ7Me3yMzyA',
  access_token_secret: 'BmuMvP6ADipSoUOrTTxNuNt8AdO7DQWVMMfeDXLFNb7iM'
});

// Fs module
var keyword ='avengers';
var option = {'track': keyword};
var tweets = [];
var i = 0;
twit.stream('statuses/filter', option, function(stream) {

    stream.on('error', function(error, code) {
      console.log("My error: " + error + ": " + code);
    });
    
    stream.on('data', function (data) {
      if(i < 1000) {
        tweets.push(data);
        i++;
      }
      else if(i == 1000){
        //fs.exists('tweets.json',function(exists) {
          fs.writeFileSync('tweets.json', JSON.stringify(tweets,null,4), "UTF-8", {'flags': 'a+'}, function (err) {
            if(err) throw err;
            console.log("Tweets saved to file!");
            console.log("You can now close the connection");
            i++;
          });
        //});
      }
    });
});

var filename;
var jsonfilename;


var tweets_db = [];
MongoClient.connect("mongodb://localhost:27017/WebFrameworkDemo", function(err, database) {
  if (err)
    return console.dir(err);
  var collection = database.collection('tweets');

  // Build database
  app.get('/postToDB', function(req, res) {
    twit.stream('statuses/filter',  option, function(stream, err) {

      if (!err) {
        console.log("inside buildMongo");
        collection.insert(tweets);
        //console.log(tweets);
        res.send("success");
      }
    });
  });

  // View tweets from Mongodb
  app.get('/ViewTweets', function(req, res) {
    console.log("inside readTweets");
    collection.find().toArray(function(err, data) {
      //console.log(data.length);
      for (var i = 0; i <data.length;i++) {
        tweets_db.push(data[i]);
      }
      req.body = tweets_db;
      //console.log(req.body);
      res.send(req.body);
    });
  });

  var num;
  // View tweets from Mongodb
  app.post('/numberTweets', function(req, res) {
    console.log("inside numberTweets");
    num = req.body.number;
    console.log(num);
    
    collection.find().toArray(function(err, data) {
      //console.log(data.length);
      for (var i = 0; i < num ;i++) {
        tweets_db.push(data[i]);
      }
      req.body = tweets_db;
      //console.log(req.body);
      res.send(req.body);
    });
  });

  // Save JSON file 
  app.post('/newJSON', function(req, res) {
    jsonfilename = req.body.JSONfile;
    //console.log(jsonfilename);
    fs.writeFile(jsonfilename+'.json', JSON.stringify(tweets_db, null, 4), function(err) {
      if(err) 
        throw err;
      console.log('JSON file saved');
    });

    res.setHeader('Content-Type', 'application/json');
    /*response has to be in the form of a JSON*/
    req.body.serverMessage = "Json file saved to Mongodb"
    /*adding a new field to send it to the angular Client */
    res.send(JSON.stringify(req.body));
  });

  // Get post data
  app.post('/post', function (req, res) {
    filename = req.body.filename;
    console.log(filename);
    //console.log(tweets_db);
    console.log("success");

    ConvertToCSV(tweets_db,filename);

    console.log("convert success!");
    // Get CSV file
    app.get('/fileCSV', function(req, res) {
        fs.readFile(filename, 'UTF-8', function(err, data) {
        if (err) throw err;
        var html = data;
        res.send(html);
        });
    });
    res.setHeader('Content-Type', 'application/json');
    /*response has to be in the form of a JSON*/
    req.body.serverMessage = "Json file saved to Mongodb"
    /*adding a new field to send it to the angular Client */
    res.send(JSON.stringify(req.body));
  })

});


// Set the sever at port 3000
http.listen(3000, function(){
  console.log('Server: localhost:3000');
});



  // Convert Json to CSV
function ConvertToCSV(obj,filename) {
  
  fs.writeFile(filename,' "created_at","id","text","user_id","user_name","user_screen_name","user_location","user_followers_count","user_friends_count","user_created_at","user_time_zone","user_profile_background_color","user_profile_image_url","geo.coordinates.0","geo.coordinates.1","coordinates.coordinates.0","coordinates.coordinates.1","place"', function(err) {
    if (err) throw err;
  });
  
  for(var i = 0; i < obj.length; i++) {
    var line = ' ';
    line += '"' + obj[i].created_at + '", ';
    line += '"' + obj[i].id + '", ';
    line += '"' + obj[i].text + '", ';
    line += '"' + obj[i].user.id + '", ';
    line += '"' + obj[i].user.name + '", ';
    line += '"' + obj[i].user.screen_name + '", ';
    line += '"' + obj[i].user.loaction + '", ';
    line += '"' + obj[i].user.followers_count + '", ';
    line += '"' + obj[i].user.friends_count + '", ';
    line += '"' + obj[i].user.created_at + '", ';
    line += '"' + obj[i].user.time_zone + '", ';
    line += '"' + obj[i].user.profile_background_color + '", ';
    line += '"' + obj[i].user.profile_background_image_url + '", ';
    // Handle if the tweet doesn't have the info of geo
    if (obj[i].geo != null) {
      line += '"' + obj[i].geo.coordinates[0] + '", ';
      line += '"' + obj[i].geo.coordinates[1] + '", ';
    } else {
      line += '"", ';
      line += '"", ';
    }

    if (obj[i].coordinates != null) {
      line += '"' + obj[i].coordinates.coordinates[0] + '", ';
      line += '"' + obj[i].coordinates.coordinates[1] + '", ';
    } else {
      line += '"", ';
      line += '"", ';
    }
    
    line += '"' + obj[i].place + '" ';
    fs.appendFile(filename, '\n' + line, function(err) {
      if(err) throw err;
    });
  };
}


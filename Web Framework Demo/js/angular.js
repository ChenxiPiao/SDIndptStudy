var app=angular.module('myApp',[]);

// Build MongoDB
  app.controller('buildDB', function($scope, $http) {
    console.log("inside buildDB");
    $scope.build = function() {
      var posting = $http ({
        method: 'GET',
        url : '/postToDB'
      })
      posting.success(function(response) {
        console.log(response);
      });
      alert("buildMongo success!");
    }
  });
var view = false;
// View Tweets
  app.controller('ViewTweets', function($scope, $http) {
    console.log("inside View Tweets");
      $scope.view = function() {
        var posting = $http ({
          method: 'GET',
          url: '/ViewTweets'
        })
        posting.success(function(response) {
          //console.log("response");
          //console.log(response);
          pull_tweets(response);
        });
        alert("Save JSON to MongoDB success!");
        view = true;
      }
      
  });

// Save JSON file
  app.controller('SaveJSON', function($scope, $http) {
    $scope.JSONfile = 'new_tweets';
    $scope.response = {};
    console.log($scope.JSONfile);
    
    $scope.saveJSON = function() {
      var posting = $http ({
        method: 'POST',
        url: '/newJSON',
        data: {JSONfile: $scope.JSONfile},
        processData: false
      })
      posting.success(function (response) {
        console.log(response);
      });
      //$scope.JSONmessage = $scope.JSONfile + ' has been saved !';
      alert($scope.JSONfile + ' has been saved !');
    };
  });
    
// Save CSV file Name
  app.controller('CSVfile', function($scope,$http) {
    $scope.filename='tweets.csv';
    $scope.response={};
    console.log($scope.filename);
    // Sent the file name to the sever and saved as a CSV file
    $scope.save=function(){
      var posting = $http({
          method: 'POST',
          /*posting to /post */
          url: '/post',
          data: {filename: $scope.filename},
          processData: false
      })
      posting.success(function (response) {
          /*executed when server responds back*/
          console.log(response); 
      });
      
      alert($scope.filename+ " has been converted!");
    };
  });

// View particular number tweets
  app.controller('ReadTweets', function($scope,$http) {
    $scope.number = 5;
    $scope.response = {};
    //console.log($scope.number);
    
    $scope.showNumber = function() {
      if(view) 
        alert("Refresh page first");
      else{
       
        //console.log("testing");
        var posting = $http({
          method:'POST',
          url:'/numberTweets',
          data: {number: $scope.number},
          processData: false
        });

        posting.success(function(response) {
          //console.log(response);
          pull_tweets(response);
        });

        alert("Success!");
      }
      
    }
  })

// View pie chart
  app.controller('Language', function($scope,$http) {
    $scope.response = {};
    console.log("inside View pie chart");
      $scope.pie = function() {
        var posting = $http ({
          method: 'GET',
          url: '/ViewTweets'
        })
        posting.success(function(response) {
          getLanguage(response);
        });
      }
     
  });

// View bar chart
  app.controller('favouriteCounts', function($scope,$http) {
    $scope.response = {};
    console.log("inside View bar chart");
      $scope.count = function() {
        var posting = $http ({
          method: 'GET',
          url: '/ViewTweets'
        })
        posting.success(function(response) {
          //console.log(response);
          getFavouriteCounts(response);
        });
      }
  });

  // View bar chart
  app.controller('devices', function($scope,$http) {
    $scope.response = {};
    console.log("inside View polar chart");
      $scope.device_type = function() {
        var posting = $http ({
          method: 'GET',
          url: '/ViewTweets'
        })
        posting.success(function(response) {
          //console.log(response);
          getDevices(response);
        });
      }
  });

      // Helper function
      function pull_tweets(data) {
        var tweets = [];
        $.each(data, function(key, val) {
          tweets.push("<li id='" + val.id + "'><div class='item'>"
             + "<img src='" + val.user.profile_image_url
             + "' onError=\"this.onerror=null;this.src='http://tech.china.com/zh_cn/science/lishi/11025917/20070904/images/14319978_2007090411065136850600.jpg';\" />"
             + "<p class='p1'>" + val.text + "</p></div></li>");
          });

        $( "<ul/>", {
          "id": "tweets_list",
          html: tweets.join("")
          }).appendTo("#tweets");


          var tags = [];
          $.each(data, function(key, val) {

            $.each(val.entities.hashtags, function(k, v) {
              tags.push("<li><div class='item'><p class='p2'>#" + v.text + "</p></div></li>");
            });

          });

          $( "<ul/>", {
            "id": "tags_list",
            html: tags.join("")
          }).appendTo("#tags");
        }

      // Compare different language
        function getLanguage(data) {
          var lang_en = 0;
          var lang_es = 0;
          var lang_in = 0;
          var lang_th = 0;
          var lang_other = 0;

          $.each(data, function(key, val) {
            if(val.lang == "en") {
              lang_en++;
            }
            else if (val.lang == "es") {
              lang_es++;
            }
            else if (val.lang == "in") {
              lang_in++;
            }
            else if (val.lang == "th") {
              lang_th++;
            }
            else {
              lang_other++;
            }
          });

          // Pie chart format
          var doughnutData= [
            {
              value: lang_en,
              color:"#F7464A",
              highlight: "#FF5A5E",
              label: "EN"
            },
            {
              value: lang_es,
              color: "#46BFBD",
              highlight: "#5AD3D1",
              label: "ES"
            },
            {
              value: lang_in,
              color: "#FDB45C",
              highlight: "#FFC870",
              label: "IN"
            },
            {
              value: lang_th,
              color: "#949FB1",
              highlight: "#A8B3C5",
              label: "TH"
            },
            {
              value: lang_other,
              color: "#4D5360",
              highlight: "#616774",
              label: "Other"
            }];

             $("#Language").click(function(){
                var ctx = document.getElementById("chart-area").getContext("2d");
                window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {responsive : true});
              });
        }

        // Get different favourite counts
        function getFavouriteCounts(data) {
          var f_0 = 0;
          var f_1 = 0;
          var f_2 = 0;
          var f_3 = 0;
          var f_4 = 0;
          var f_5 = 0;
          var f_6 = 0;
          var s_0 = 0;
          var s_1 = 0;
          var s_2 = 0;
          var s_3 = 0;
          var s_4 = 0;
          var s_5 = 0;
          var s_6 = 0;
   
           $.each(data, function(key, val) {
          // Favourite counts
             if(val.user.favourites_count <= 100) {
                f_0 ++;
              }
              else if (val.user.favourites_count <= 500 && val.user.favourites_count > 100) {
                f_1 ++;
              }
              else if (val.user.favourites_count <= 1000 && val.user.favourites_count > 500) {
                f_2 ++;
              }
              else if (val.user.favourites_count <= 3000 && val.user.favourites_count > 1000) {
                f_3 ++;
              }
              else if (val.user.favourites_count <= 6000 && val.user.favourites_count > 3000) {
                f_4 ++;
              }
              else if (val.user.favourites_count <= 9000 && val.user.favourites_count > 6000) {
                f_5 ++;
              }
              else {
                f_6++;
              }

            // Status counts
              if(val.user.statuses_count <= 100) {
                s_0 ++;
              }
              else if (val.user.statuses_count <= 500 && val.user.statuses_count > 100) {
                s_1 ++;
              }
              else if (val.user.statuses_count <= 1000 && val.user.statuses_count > 500) {
                s_2 ++;
              }
              else if (val.user.statuses_count <= 3000 && val.user.statuses_count > 1000) {
                s_3 ++;
              }
              else if (val.user.statuses_count <= 6000 && val.user.statuses_count > 3000) {
                s_4 ++;
              }
              else if (val.user.statuses_count <= 9000 && val.user.statuses_count > 6000) {
                s_5 ++;
              }
              else {
                s_6 ++;
              }
            });

          var barChartData = {
              labels : ["0-100","101-500","501-1000","1001-3000","3001-6000","6001-9000",">9000"],
              datasets : [
              //Favourite counts
                {
                  fillColor : "rgba(220,220,120,130)",
                  strokeColor : "rgba(220,220,120,120)",
                  highlightFill: "rgba(220,220,120,100)",
                  highlightStroke: "rgba(220,220,220,1)",
                  data : [f_0, f_1, f_2, f_3, f_4, f_5, f_6]
                },
                // Status counts
                {
                  fillColor : "rgba(151,187,205,0.5)",
                  strokeColor : "rgba(151,187,205,0.8)",
                  highlightFill : "rgba(151,187,205,0.75)",
                  highlightStroke : "rgba(151,187,205,1)",
                  data : [s_0, s_1, s_2, s_3, s_4, s_5, s_6]
                }
              ] 
            };

           $("#counts").click(function(){
              var ctx = document.getElementById("canvas").getContext("2d");
              window.myBar = new Chart(ctx).Bar(barChartData, {
                responsive : true
              });
            });

          }


          // Compare different devices
        function getDevices(data) {
          var apple = 0;
          var android = 0;
          var blackberry = 0;
          var web = 0;
          var other = 0;

          $.each(data, function(key, val) {
            if(val.source == "<a href=\"http://twitter.com/download/iphone\" rel=\"nofollow\">Twitter for iPhone</a>" || 
                val.source == "<a href=\"http://twitter.com/#!/download/ipad\" rel=\"nofollow\">Twitter for iPad</a>" ||
                val.source ==  "<a href=\"http://itunes.apple.com/us/app/twitter/id409789998?mt=12\" rel=\"nofollow\">Twitter for Mac</a>") {
              apple++;
            }
            else if (val.source == "<a href=\"http://twitter.com/download/android\" rel=\"nofollow\">Twitter for Android</a>") {
              android++;
            }
            else if (val.source == "<a href=\"http://www.twitter.com\" rel=\"nofollow\">Twitter for BlackBerry</a>" ||
                val.source == "<a href=\"http://blackberry.com/twitter\" rel=\"nofollow\">Twitter for BlackBerry®</a>") {
              blackberry++;
            }
            else if (val.source == "<a href=\"http://twitter.com\" rel=\"nofollow\">Twitter Web Client</a>") {
              web++;
            }
            else {
              other++;
            }
          });

          // Polar chart format
          var polarData = [
            {
              value: apple,
              color:"#F7464A",
              highlight: "#FF5A5E",
              label: "Apple"
            },
            {
              value: android,
              color: "#46BFBD",
              highlight: "#5AD3D1",
              label: "Android"
            },
            {
              value: blackberry,
              color: "#FDB45C",
              highlight: "#FFC870",
              label: "Blackberry"
            },
            {
              value: web,
              color: "#949FB1",
              highlight: "#A8B3C5",
              label: "Twitter"
            },
            {
              value: other,
              color: "#4D5360",
              highlight: "#616774",
              label: "Other"
            }

          ];


             $("#device").click(function(){
                var ctx = document.getElementById("chart").getContext("2d");
                window.myPolarArea = new Chart(ctx).PolarArea(polarData, {
                  responsive:true
                });
              });
        }

      function tick() {
        $('#tweets_list li:first').animate( {'opacity':0}, 200, function () {
          $(this).appendTo($('#tweets_list')).css('opacity', 1);
        });

        $('#tags_list li:first').animate( {'opacity':0}, 200, function () {
          $(this).appendTo($('#tags_list')).css('opacity', 1);
        });
      }
      setInterval(function(){ tick () }, 3000);

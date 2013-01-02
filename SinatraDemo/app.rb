# app.rb
set :haml, :format =&gt; :html5
 
get "/" do
  haml :index
end

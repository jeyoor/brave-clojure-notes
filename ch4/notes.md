


Repl dump
----
----

fwpd.core=> (vector vamp-keys ["Jacob Black" "3"])
[[:name :glitter-index] ["Jacob Black" "3"]]

fwpd.core=> (def mini_vec_step_1_list (vector vamp-keys ["Jacob Black" "3"]))
#'fwpd.core/mini_vec_step_1_list
fwpd.core=> mini_vec_step_1_list
[[:name :glitter-index] ["Jacob Black" "3"]]

fwpd.core=> (let [val mini_vec_step_1_list] val )
[[:name :glitter-index] ["Jacob Black" "3"]]

fwpd.core=> (let [[vamp-keys value] mini_vec_step_1_list] vamp-keys )
[:name :glitter-index]
fwpd.core=> (let [[vamp-keys value] mini_vec_step_1_list] value )
["Jacob Black" "3"]

;Realized I was on the wrong track, missed a map

fwpd.core=> (def mini_vec_step_1_list (map vector vamp-keys ["Jacob Black" "3"]))
#'fwpd.core/mini_vec_step_1_list

fwpd.core=> mini_vec_step_1_list
([:name "Jacob Black"] [:glitter-index "3"])


fwpd.core=> (let [[vamp-key value] mini_vec_step_1_list] vamp-key)
[:name "Jacob Black"]
fwpd.core=> (let [[vamp-key value] mini_vec_step_1_list] value)
[:glitter-index "3"]

fwpd.core=> (let [[vamp-key value] mini_vec_step_1_list] (assoc {} vamp-key (convert vamp-key value)))

NullPointerException   fwpd.core/convert (core.clj:22)

;realized I was on the wrong track, let's look at reduce

fwpd.core=> (reduce (fn [row-map [vamp-key value]] (assoc row-map vamp-key (convert vamp-key value))) {} mini_vec_step_1_list)
{:name "Jacob Black", :glitter-index 3}

;

fwpd.core=> (let [[vamp-key value] (first mini_vec_step_1_list)] vamp-key)
:name
fwpd.core=> (let [[vamp-key value] (first mini_vec_step_1_list)] value)
"Jacob Black"
fwpd.core=> (let [[vamp-key value] (first mini_vec_step_1_list)] (assoc {} vamp-key (convert vamp-key value)))
{:name "Jacob Black"}
fwpd.core=> 



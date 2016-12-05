(ns fwpd.core)
(def filename "suspects.csv")

(defn reload
  "reload this file"
  []
  (do
    (load-file "src/fwpd/core.clj")
    (use 'fwpd.core)))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn glitter-filter-names
  "retrieve names from records with at least the minimum glitter index"
  [minimum-glitter records]
  (map #(% :name) (glitter-filter minimum-glitter records)))

(defn find-vampires!
  "parse the file and return the names of records with a glitter-index greater than 3"
  []
  (map #(% :name) (glitter-filter 3 (mapify (parse (slurp filename))))))

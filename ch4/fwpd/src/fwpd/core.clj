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

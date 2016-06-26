(ns rx-clojure.core
  (:use [rx.lang.clojure.core :as rx]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(def transform [my-observable]
  (->> my-observable
       (rx/map #(clojure.string/lower-case %1))))


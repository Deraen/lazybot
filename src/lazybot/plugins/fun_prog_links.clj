(ns lazybot.plugins.fun-prog-links
  (:require [lazybot.registry :refer [send-message defplugin]]
            [clj-http.client :as http]))

(def api "https://fun-prog-links.herokuapp.com:443/links")

(defn insert-link [link]
  (http/post api {:body (pr-str link)
                  :content-type :edn}))

(defn link [{:keys [nick args] :as com-m}]
  (let [[uri & tags] args

        {:keys [status]}
        (insert-link {:nick nick
                      :tags tags
                      :uri uri})]
    (send-message com-m (case status
                          200 "Ok"
                          "Error"))))

(defplugin
  (:cmd
   "Save a link. [uri & tags]."
   #{"link"} link))

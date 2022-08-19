(ns template.service
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            
            [template.endpoints.app :as app]))

(def common-interceptors [(body-params/body-params) http/json-body])

(def routes #{["/health" :get (conj common-interceptors `app/health-check)]})

(def service {:env :prod
              ::http/routes routes
              ::http/resource-path "/public"
              ::http/type :jetty
              ::http/port 3000
              ::http/container-options {:h2c? true
                                        :h2? false
                                        :ssl? false}})

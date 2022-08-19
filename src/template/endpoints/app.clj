(ns template.endpoints.app)

(defn health-check
  "The health check endpoint"
  [req]
  {:status 200 :body {:message "OK"}})

(defproject widgets "0.1.0-SNAPSHOT"
  :dependencies
  [[org.clojure/clojure "1.11.1"]
   [thheller/shadow-cljs "2.20.2"]
   [reagent "1.1.1"]
   [re-frame "1.3.0"]]

  :source-paths
  ["src"]

  :test-paths
  ["test"]

  :profiles
  {:dev {:dependencies
         [[binaryage/devtools "1.0.6"]
          [day8.re-frame/re-frame-10x "1.5.0"]
          [day8.re-frame/tracing "0.6.2"]]

         :source-paths
         ["src" "dev"]

         :clean-targets
         ^{:protect false}
         ["resources/public/js/compiled" :target-path]}})

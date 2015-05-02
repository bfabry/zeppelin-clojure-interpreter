(defproject clojureinterpreter "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.apache.zeppelin/zeppelin-interpreter "0.5.0-SNAPSHOT"]
                 [org.clojure/tools.nrepl "0.2.10"]]
  :prep-tasks [["compile" "clojureinterpreter.core"]
               "javac"
               "compile"]
  :java-source-paths ["src-java"])



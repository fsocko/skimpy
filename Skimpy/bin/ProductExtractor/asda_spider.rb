require "selenium-webdriver"

wbdrv = Selenium::WebDriver.for :firefox
wbdrv.manage.timeouts.implicit_wait = 10

wbdrv.get "http://groceries.asda.com"
food_nav_links = wbdrv.find_elements(:partial_link_text, "Food")

# Collect links, but leave out frozen food.
food_nav_links.collect! { |n| n.attribute("href") }

food_nav_links.each do |fd|
  wbdrv.get fd
  departments = wbdrv.find_elements(:css, "li.active.tab li a")
  departments.delete_if { |d| d.text =~ /Free From/ || d.text =~ /Special Offers/ }
  departments.collect! { |d| d.attribute("href") }

  departments.each do |dept|
    wbdrv.get dept
    aisles = wbdrv.find_elements(:css, "ul.menu_aisles li a")
    aisles.collect! { |a| a.attribute("href") }

    aisles.each do |aisle|
      wbdrv.get aisle
      shelves = wbdrv.find_elements(:css, "ul.menu_shelf li a")
      shelves.collect! { |a| a.attribute("href") }

      shelves.each do |shlf|
        begin
          wbdrv.get shlf
          listings = wbdrv.find_elements(:css, "#listings .listing .title a")
          puts wbdrv.find_element(:css, "h1").text
          listings.each do |a|
            puts a.attribute("href")
          end
        rescue Selenium::WebDriver::Error::NoSuchElementError
          puts "Something went wrong at #{shlf}"
        end
      end
    end
  end
end

wbdrv.quit

require "selenium-webdriver"

wbdrv = Selenium::WebDriver.for :firefox
wbdrv.manage.timeouts.implicit_wait = 10

links_file = File.new('links_file.txt', 'w')
total = 0

wbdrv.get "http://groceries.asda.com"
food_nav_links = wbdrv.find_elements(:partial_link_text, "Food")

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
			subcat = wbdrv.find_element(:css, "h1").text
			shelves.each do |shlf|
				begin
					wbdrv.get shlf
					listings = wbdrv.find_elements(:css, "#listings .listing .title a")
					links_file.puts "#{subcat}; #{wbdrv.find_element(:css, "h1").text}"
					listings.each do |a|
						links_file.puts a.attribute("href")
					end
				
					counter = wbdrv.find_element(:css, '#componentsContainer p.itemCount').text
					p = /-(\d+)/.match(counter)[1].to_i
					t = /of (\d+)/.match(counter)[1].to_i
					total += p
					while p < t
						wbdrv.find_element(:css, '#listings-pagination-container .listings-pagination-wrapper a.button.forward-listing').click
						listings = wbdrv.find_elements(:css, "#listings .listing .title a")
						listings.each do |a|
							links_file.puts a.attribute("href")
						end
						counter = wbdrv.find_element(:css, '#componentsContainer p.itemCount').text
						p = /-(\d+)/.match(counter)[1].to_i
						t = /of (\d+)/.match(counter)[1].to_i
						total += p
					end
				print "\rTotal items: #{total}   "
				rescue Selenium::WebDriver::Error::NoSuchElementError
					puts "Something went wrong at #{shlf}"
				rescue Selenium::WebDriver::Error::StaleElementReferenceError
					puts "Page might have changed"
				end
			end
		end
	end
end
wbdrv.quit